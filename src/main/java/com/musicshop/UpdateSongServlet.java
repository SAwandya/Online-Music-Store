package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateSongServlet")
public class UpdateSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("aid");
		int convertedId = Integer.parseInt(id);
		String des = request.getParameter("description");
		String song = request.getParameter("name");
		
		
		boolean isTrue;
		 
		 isTrue = MusicDBUtil.updateSong(convertedId, des, song);
		 
		 if(isTrue == true) {
			 
			 //List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
			 
			 //request.setAttribute("cusDetails", cusDetails);
			 
			 response.sendRedirect(request.getContextPath() + "/Landing");
		 }else {
			 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			 dis.forward(request, response);
		 }
	}

}
