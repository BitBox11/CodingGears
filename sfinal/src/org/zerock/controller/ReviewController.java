package org.zerock.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zerock.domain.Pager;
import org.zerock.listen.RequestUtil;
import org.zerock.persistence.ReviewDAO;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review")
public class ReviewController extends HttpServlet {

	private static ReviewDAO dao;
	private static RequestUtil util;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ReviewDAO dao = (ReviewDAO) config.getServletContext().getAttribute("ReviewDAO");
		RequestUtil util = (RequestUtil) config.getServletContext().getAttribute("util");
		super.init(config);
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("review get");
		

		int page = 1;
		try{
			page = Integer.parseInt(request.getParameter("pageNum"));
		}catch(Exception e){
		}

		try {
			System.out.println("page: "+page);
			ReviewDAO dao2 = new ReviewDAO();
			int total = dao2.getListCount();
			
			request.setAttribute("list", dao2.readList(page));
			request.setAttribute("pager", new Pager(page,total));
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		request.getRequestDispatcher("/WEB-INF/board/reviewlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
