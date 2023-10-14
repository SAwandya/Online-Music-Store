package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteArtistServlet")
public class deleteArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aid = request.getParameter("aid");
		
		int convertedId = Integer.parseInt(aid);
		
		boolean isTrue;
		boolean isTrue1;
		boolean isTrue2;
		int sid = 0;
		
		List<Songs> songDetails = MusicDBUtil.getFromDownAndSongs(convertedId);
		
		if (songDetails != null) {
		   
		    for (Songs song : songDetails) {
		       
		        sid = song.getSid();
		        System.out.println(sid);
		      
		    }
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Unsuccess.jsp");
			dispatcher.forward(request, response);
		}
		
		  
        isTrue1 = MusicDBUtil.deleteSongFromDownloadByAdmin(sid);
        isTrue = MusicDBUtil.deleteSongByAdmin(convertedId);
        isTrue2 = MusicDBUtil.deleteArtist(convertedId);
        
        if(isTrue2 == true) {
			
			response.sendRedirect(request.getContextPath() + "/GetArtistsServlet");
	
		}else {
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("Unsuccess.jsp");
			//dispatcher.forward(request, response);
		}
		
		
		
		
		
		
	}

}
