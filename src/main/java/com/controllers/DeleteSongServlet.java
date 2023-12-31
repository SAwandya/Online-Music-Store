package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteSongServlet")
public class DeleteSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("sid");
		
		int convertedId = Integer.parseInt(sid);
		
		boolean isTrue;
		boolean isTrue1;
		
		isTrue1 = MusicDBUtil.deleteFromLibraryByArtist(convertedId);
		isTrue = MusicDBUtil.deleteSong(convertedId);
		
		
		if(isTrue == true) {
			
			response.sendRedirect(request.getContextPath() + "/Landing");
	
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Unsuccess.jsp");
			dispatcher.forward(request, response);
		}
	}

}
