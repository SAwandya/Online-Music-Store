package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ArtistRegisterSevlet")
public class ArtistRegisterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue ;
		boolean isTrue2;
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		
		String errorMessage = "";

		// Check for empty fields
		if (username == null || username.trim().isEmpty()) {
		    errorMessage += "Username is required.<br>";
		}
		if (password == null || password.trim().isEmpty()) {
		    errorMessage += "Password is required.<br>";
		}
		if (name == null || name.trim().isEmpty()) {
		    errorMessage += "Email is required.<br>";
		}
		
		if (!errorMessage.isEmpty()) {
		    
		    request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("ArtistRegisterForm.jsp").forward(request, response);
		    return;
		}
		
		isTrue = MusicDBUtil.getArtist(username);
		
		if(isTrue == true) {
			
			errorMessage += "Username already exist.<br>";
			request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("ArtistRegisterForm.jsp").forward(request, response);
		    return;
			
		}else {
			
			isTrue2 = MusicDBUtil.insertArtist(name, username, password);
			
			if(isTrue2 == true) {
				
				response.sendRedirect(request.getContextPath() + "/main");
			}else {
				
				RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
				dis2.forward(request, response);
			}
		}
	}

}
