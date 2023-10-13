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

@WebServlet("/main")
public class getLibraryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String logout = request.getParameter("log");
		String song = request.getParameter("search");
		
		if("logout".equals(logout)) {
			
			HttpSession session = request.getSession();

			session.removeAttribute("customerList");
		}
		
		
		HttpSession session = request.getSession();
        List<Customer> customerList = (List<Customer>) session.getAttribute("customerList");
		
        if(song == null) {
			
        	List<Songs> AllSongs = MusicDBUtil.getAllSongs();
        	 request.setAttribute("AllSongs", AllSongs);
		}else {
			
			List<Songs> AllSongs = MusicDBUtil.searchSongs(song);
			request.setAttribute("AllSongs", AllSongs);
		}
		
        if (customerList != null) {
            
            for (Customer customer : customerList) {
             
                int id = customer.getUid();
                List<Songs> LibraryDetails = MusicDBUtil.getSongLibraryDetails(id);
                request.setAttribute("LibraryDetails", LibraryDetails);
                
            }}else {
            	
            	
            }
        
		
		
		 
		 
		
		 
		 if (customerList != null) {
	        
	               
	            request.setAttribute("customerList", customerList);
	            
	        }
		 
		 RequestDispatcher dis = request.getRequestDispatcher("main.jsp");
		 dis.forward(request, response);
	}

}
