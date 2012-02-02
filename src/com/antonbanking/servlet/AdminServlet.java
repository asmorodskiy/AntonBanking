package com.antonbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antonbanking.service.MainService;


// store userid in context of session

public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		try {	
			request.setAttribute("ATMUsers",MainService.getAllUsers());
			request.getRequestDispatcher("index.jsp").forward(request,response);
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
