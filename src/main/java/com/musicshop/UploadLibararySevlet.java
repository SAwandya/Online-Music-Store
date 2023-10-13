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

@WebServlet("/UploadLibararySevlet")
public class UploadLibararySevlet extends HttpServlet {
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
	                isTrue = MusicDBUtil.insertToLibrary(convertedId, id);
	                //List<Songs> LibraryDetails = MusicDBUtil.getSongLibraryDetails(id);
	                //request.setAttribute("LibraryDetails", LibraryDetails);
	                
	            }}
			
			
			
			if(isTrue = true) {
				response.sendRedirect(request.getContextPath() + "/main");
				
			}else {
				RequestDispatcher dis2 = request.getRequestDispatcher("ussuccess.jsp");
				dis2.forward(request, response);
			}
		
	}

}
