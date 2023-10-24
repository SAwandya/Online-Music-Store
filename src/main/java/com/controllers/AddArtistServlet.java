package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddArtistServlet")
public class AddArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        	
        boolean isTrue;
		
		isTrue = MusicDBUtil.insertArtist(name, username, password);
		
		if(isTrue = true) {
			response.sendRedirect(request.getContextPath() + "/GetArtistsServlet");
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ussuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
