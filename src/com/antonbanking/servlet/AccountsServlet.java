package com.antonbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antonbanking.business.CurrencyType;
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
			int userId = Integer.valueOf(request.getParameter("userId"));
			ArrayList<String> to_jsp = new ArrayList<String>();
			CurrencyType[] currency_arr= CurrencyType.values();
			for(CurrencyType val1 : currency_arr)
				to_jsp.add(val1.getName());
			String usr_name = MainService.getUserName(userId);
			request.setAttribute("Ac",MainService.getAllAccounts(userId));
			request.setAttribute("Types",to_jsp);
			request.setAttribute("UserId",request.getParameter("userId"));
			request.setAttribute("UserName",usr_name);
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
