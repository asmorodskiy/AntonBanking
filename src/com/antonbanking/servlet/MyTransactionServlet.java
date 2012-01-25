package com.antonbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.antonbanking.service.MainService;

public class MyTransactionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9142114737047146060L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		try {	
			int userId = Integer.valueOf(request.getParameter("userId"));			
			String usr_name = MainService.getUserName(userId);
			int account_id = Integer.valueOf(request.getParameter("accountId"));
			request.setAttribute("Transactions",MainService.getAllMyTransactions(account_id));			
			request.setAttribute("UserId",request.getParameter("userId"));
			request.setAttribute("UserName",usr_name);
			request.setAttribute("CurrencyName",MainService.getAccountCurrencyName(account_id));
			request.setAttribute("accountId",String.valueOf(account_id));
			request.getRequestDispatcher("mytransactions.jsp").forward(request,response);
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
