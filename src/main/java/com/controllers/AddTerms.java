package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddTerms")
public class AddTerms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String term = request.getParameter("area");
        	
        boolean isTrue;
		
		isTrue = MusicDBUtil.AddTerms(term);
		
		if(isTrue = true) {
			response.sendRedirect(request.getContextPath() + "/GetArtistsServlet");
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ussuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
