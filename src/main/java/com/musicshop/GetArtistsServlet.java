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
		
		String search = request.getParameter("search");
		String searchTerms = request.getParameter("searchTerms");
		
		if(search == null) {
			
			List<Artists> allArtist = MusicDBUtil.getAllArtists();
			request.setAttribute("allArtist", allArtist);
		}else {
			List<Artists> allArtist = MusicDBUtil.searchArtists(search);
			request.setAttribute("allArtist", allArtist);
		}
		
		if(searchTerms == null) {
			
			List<Terms> allTerms = MusicDBUtil.getAllterms();
			request.setAttribute("allTerms", allTerms);
		}else {
			
			List<Terms> allTerms = MusicDBUtil.searchTerms(searchTerms);
			request.setAttribute("allTerms", allTerms);
		}

		
		RequestDispatcher dis = request.getRequestDispatcher("AdminDashboard.jsp");
		dis.forward(request, response);
	}

}
