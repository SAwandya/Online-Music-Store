package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/Landing")
public class ViewSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			 String song = request.getParameter("search");
			 			
			 HttpSession session = request.getSession();
		     List<Artists> ArtistList = (List<Artists>) session.getAttribute("ArtistsList");
		     
		     int id = 0;
		     
		     if (ArtistList != null) {
		            
		            for (Artists artist : ArtistList) {
		             
		                id = artist.getId();		                	            
		                
		            }
		            
		            
	                if(song == null){
	   				 
	   				 List<Songs> songDetails = MusicDBUtil.getSongToArtist(id);
	   				 
	   				 request.setAttribute("songDetails", songDetails);
	   				 
	   				 RequestDispatcher dis = request.getRequestDispatcher("uploadMusic.jsp");
	   				 dis.forward(request, response);
	   			 }else {
	   				 
	   				 List<Songs> songDetails = MusicDBUtil.searchSongsByArtist(song, id);
	   				 request.setAttribute("songDetails", songDetails);
	   				 
	   				 RequestDispatcher dis = request.getRequestDispatcher("uploadMusic.jsp");
	   				 dis.forward(request, response);
	   			 }
		     
		     }
		     
			 
			
		
			
		
	}

}
