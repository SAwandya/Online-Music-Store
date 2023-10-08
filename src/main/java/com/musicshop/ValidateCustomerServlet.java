package com.musicshop;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet("/ValidateCustomerServlet")
public class ValidateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errorMessage = "";
		
		List<Customer> customer = MusicDBUtil.validateCustomer(username, password);
		
		if(customer != null && !customer.isEmpty()) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("customerList", customer);
			
			response.sendRedirect(request.getContextPath() + "/main");
		}else {
			
			errorMessage += "username or password incorrect!!<br>";
			request.setAttribute("errorMessage", errorMessage);
		    request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		    return;
		}
		
		
	}

}
