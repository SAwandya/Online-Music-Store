package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GetArtistsServlet")
public class GetArtistsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Artists> allArtist = MusicDBUtil.getAllArtists();
		List<Terms> allTerms = MusicDBUtil.getAllterms();
		
		request.setAttribute("allArtist", allArtist);
		request.setAttribute("allTerms", allTerms);
		
		RequestDispatcher dis = request.getRequestDispatcher("AdminDashboard.jsp");
		dis.forward(request, response);
	}

}
