package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class getLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Songs> LibraryDetails = MusicDBUtil.getSongLibraryDetails(1);
		List<Songs> AllSongs = MusicDBUtil.getAllSongs();
		 
		 request.setAttribute("LibraryDetails", LibraryDetails);
		 request.setAttribute("AllSongs", AllSongs);
		 
		 RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		 dis.forward(request, response);
	}

}
