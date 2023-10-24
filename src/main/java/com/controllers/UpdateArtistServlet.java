package com.musicshop;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UpdateArtistServlet")
public class UpdateArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("aid");
		int convertedId = Integer.parseInt(id);
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isTrue;
		 
		 isTrue = MusicDBUtil.updateArtist(convertedId, name, username, password);
		 
		 if(isTrue == true) {
			 
			 //List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
			 
			 //request.setAttribute("cusDetails", cusDetails);
			 
			 response.sendRedirect(request.getContextPath() + "/GetArtistsServlet");
		 }else {
			 RequestDispatcher dis = request.getRequestDispatcher("Unsuccess.jsp");
			 dis.forward(request, response);
		 }
	}

}
