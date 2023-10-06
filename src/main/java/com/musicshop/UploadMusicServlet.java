package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/UploadMusicServlet")
public class UploadMusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		String fileName = "new";
        String uploadPath = "newpath";
        int cid = 1;
        int aid = 2;
        	
        boolean isTrue;
		
		isTrue = MusicDBUtil.insertSong(name, uploadPath, fileName, cid, aid, description);
		
		if(isTrue = true) {
			response.sendRedirect(request.getContextPath() + "/Landing");
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ussuccess.jsp");
			dis2.forward(request, response);
		}
        	
       
	}

}
