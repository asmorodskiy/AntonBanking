package com.antonbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antonbanking.service.MainService;

public class AddAccountServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5633028630836351066L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {					
			
			try {
				MainService.AddAccount(request.getParameter("UserId"),request.getParameter("typ"),request.getParameter("Quantity"));
				response.sendRedirect("/AntonBanking/AccountsServlet");
			} catch (ClassNotFoundException e) {
				request.getRequestDispatcher("error.html").forward(request,response);
			} catch (SQLException e) {
				request.getRequestDispatcher("error.html").forward(request,response);
			}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
