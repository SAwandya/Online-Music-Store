package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteTerms")
public class DeleteTerms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tid = request.getParameter("tid");
		
		int convertedId = Integer.parseInt(tid);
		
		boolean isTrue;
		
		isTrue = MusicDBUtil.deleteTerms(convertedId);
		
		if(isTrue == true) {
			
			response.sendRedirect(request.getContextPath() + "/GetArtistsServlet");
	
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Unsuccess.jsp");
			dispatcher.forward(request, response);
		}
	}

}
