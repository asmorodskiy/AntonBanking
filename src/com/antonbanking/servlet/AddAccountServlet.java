package com.antonbanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.antonbanking.service.MainService;

public class AddAccountServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5633028630836351066L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if(session!=null) 
		{
			String userid=(String)session.getAttribute("ATMUserID");
			MainService.AddAccount(userid,(String)request.getParameter("CurrencyTypes"),request.getParameter("ATMQuantity"));				
			response.sendRedirect(String.format("/AntonBanking/AccountsServlet?ATMUserID=%s",userid));
		}			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
