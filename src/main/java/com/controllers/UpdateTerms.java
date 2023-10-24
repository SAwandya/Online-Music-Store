package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateTerms")
public class UpdateTerms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("aid");
		int convertedId = Integer.parseInt(id);
		String description = request.getParameter("area");
        	
        boolean isTrue;
		
		isTrue = MusicDBUtil.updateTerms(convertedId, description);
		
		if(isTrue = true) {
			response.sendRedirect(request.getContextPath() + "/GetArtistsServlet");
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ussuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
