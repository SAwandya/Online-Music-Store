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

@WebServlet("/DeleteFromLibrary")
public class DeleteFromLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sid = request.getParameter("sid");
		
		int convertedId = Integer.parseInt(sid);
		
		boolean isTrue;
		
		 HttpSession session = request.getSession();
	     List<Customer> customerList = (List<Customer>) session.getAttribute("customerList");
	     
	     if (customerList != null) {
	            
	            for (Customer customer : customerList) {
	             
	                int id = customer.getUid();
	               
	                isTrue = MusicDBUtil.deleteFromLibrary(id, convertedId);
	                
	                if(isTrue == true) {
	        			
	        			response.sendRedirect(request.getContextPath() + "/main");
	        	
	        		}else {
	        			
	        			RequestDispatcher dispatcher = request.getRequestDispatcher("Unsuccess.jsp");
	        			dispatcher.forward(request, response);
	        		}
	            }}else {
	            	
	            	RequestDispatcher dispatcher = request.getRequestDispatcher("Unsuccess.jsp");
        			dispatcher.forward(request, response);
	            }
		
		
	}

}
