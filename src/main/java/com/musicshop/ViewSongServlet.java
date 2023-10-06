package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Landing")
public class ViewSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			 
			 List<Songs> songDetails = MusicDBUtil.getSongDetails();
			 
			 request.setAttribute("songDetails", songDetails);
			 
			 RequestDispatcher dis = request.getRequestDispatcher("uploadMusic.jsp");
			 dis.forward(request, response);
		
	}

}
