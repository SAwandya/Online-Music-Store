package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteFromLibrary")
public class DeleteFromLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("sid");
		
		int uid = 1;
		
		int convertedId = Integer.parseInt(sid);
		
		boolean isTrue;
		
		isTrue = MusicDBUtil.deleteFromLibrary(uid, convertedId);
		
		if(isTrue == true) {
			
			response.sendRedirect(request.getContextPath() + "/main");
	
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Unsuccess.jsp");
			dispatcher.forward(request, response);
		}
	}

}
