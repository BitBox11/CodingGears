package org.zerock.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.ApplicationPart;
import org.apache.tomcat.util.descriptor.web.ApplicationParameter;
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

		// 리스너의 list 어떻게 받아오는지 ....?
		System.out.println("do..............get..................review");
		int pageNum;

		try {

			if (request.getParameter("pageNum") != null) {
				pageNum = util.getInt(request.getParameter("pageNum"), 1);
				request.setAttribute("list", new ReviewDAO().readList(pageNum));// 리스너
				System.out.println("pageNum 이다." + pageNum);
				
				int totalCount = dao.CountTotal();
				totalCount = util.getInt(request.getParameter("totalCount"), 1);
				request.setAttribute("pager", new Pager(pageNum, totalCount));
				System.out.println("totalCOunt" + totalCount);
				
			} else {
				System.out.println("페이지 없을때 ");
				
				pageNum = 1;

				request.setAttribute("list", new ReviewDAO().readList(pageNum));
				int totalCount = 60;
//				totalCount = util.getInt(request.getParameter("totalCount"), 1);
				request.setAttribute("pager", new Pager(pageNum, totalCount));
				System.out.println("totalCOunt" + totalCount);
			}


		} catch (Exception e) {
			e.getMessage();
			System.out.println(" 오류야!!");
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
