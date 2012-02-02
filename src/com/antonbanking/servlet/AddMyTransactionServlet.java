package com.antonbanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.antonbanking.service.MainService;

public class AddMyTransactionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 229786051262174311L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {					
			
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
				String userid=(String) session.getAttribute("ATMUserID");
				String accountId = (String) session.getAttribute("ATMAccountID");
				String tmp = request.getParameter("valplus");
				double value;
				if(tmp == null)
				{
					tmp = request.getParameter("valminus");
					
					if(tmp == null)
					{
						request.setAttribute("error","error");
						response.sendRedirect(String.format("/AntonBanking/MyTransactionServlet?ATMUserID=%s&ATMAccountID=%s",userid,accountId));
					}
					else
					{ 
						value = - Double.valueOf(tmp);
						MainService.AddTransaction(accountId,value);
					}
				}
				else 
				{
					value = Double.valueOf(tmp);
					MainService.AddTransaction(accountId,value);
				}								
				response.sendRedirect(String.format("/AntonBanking/MyTransactionServlet?ATMUserID=%s&ATMAccountID=%s",userid,accountId));
			} 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
