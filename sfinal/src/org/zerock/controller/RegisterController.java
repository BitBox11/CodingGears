package org.zerock.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zerock.domain.ReviewVO;
import org.zerock.persistence.ReviewDAO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("register get");
		
		request.getRequestDispatcher("/WEB-INF/board/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("register post");
		
		String[] userId= request.getParameterValues("userId");
		String[] menuNo= request.getParameterValues("menuNo");
		String[] score= request.getParameterValues("score");
		String[] review= request.getParameterValues("review");
		
		ReviewVO vo = new ReviewVO();
		
		vo.setMemberId(userId[0]);
		vo.setMenuNo(Integer.parseInt(menuNo[0]));
		vo.setScore(Integer.parseInt(score[0]));
		vo.setReview(review[0]);
		
		System.out.println(userId[0]);
		System.out.println(menuNo[0]);
		System.out.println(score[0]);
		System.out.println(review[0]);
		System.out.println(vo + "vo????");
		ReviewDAO dao= new ReviewDAO() ;
		dao.register(vo);  
				
		response.sendRedirect("/review");
	}

}
