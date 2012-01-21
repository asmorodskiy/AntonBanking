package com.antonbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antonbanking.service.MainService;

public class AddUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5124157447188342797L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {					
			
			
			try {
				MainService.AddUser(request.getParameter("NewUser"));
			} catch (ClassNotFoundException e) {
				request.getRequestDispatcher("error.html").forward(request,response);
			} catch (SQLException e) {
				request.getRequestDispatcher("error.html").forward(request,response);
			}
			response.sendRedirect("/AntonBanking/AdminServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
