package com.antonbanking.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.antonbanking.business.CurrencyType;
import com.antonbanking.service.MainService;

public class AccountsServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3083452516228510428L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			int userId = Integer.valueOf(request.getParameter("ATMUserID"));
			ArrayList<String> to_jsp = new ArrayList<String>();
			CurrencyType[] currency_arr= CurrencyType.values();
			for(CurrencyType val1 : currency_arr)
				to_jsp.add(val1.getName());
			String usr_name = MainService.getUserName(userId);
			request.setAttribute("ATMAccounts",MainService.getAllAccounts(userId));
			request.setAttribute("ATMCurrencyTypes",to_jsp);			 			
			request.setAttribute("ATMUserName",usr_name);
			
			session.setAttribute("ATMUserID",request.getParameter("ATMUserID"));			
			
			request.getRequestDispatcher("accounts.jsp").forward(request,response);
		} 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
