package com.antonbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antonbanking.service.MainService;

//import com.antonbanking.service.MainService;

public class AccountsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3083452516228510428L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		try {	
			int userId = (Integer)request.getAttribute("userId");
			request.setAttribute("Accoounts",MainService.getAllAccounts(userId));
			request.getRequestDispatcher("accounts.jsp").forward(request,response);
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
