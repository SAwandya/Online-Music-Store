package com.musicshop;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/ValidateArtistServlet")
public class ValidateArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMessage = "";
		
		List<Artists> Artists = MusicDBUtil.validateArtist(username, password);
		
		if(Artists != null && !Artists.isEmpty()) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("ArtistsList", Artists);
			
			response.sendRedirect(request.getContextPath() + "/GetArtistsServlet");
		}else {
			
			errorMessage += "username or password incorrect!!<br>";
			request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("ArtistLogin.jsp").forward(request, response);
		    return;
		}
	}

}
