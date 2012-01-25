package com.antonbanking.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antonbanking.service.MainService;

public class AddMyTransactionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 229786051262174311L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {					
			
			try {
				String userid=request.getParameter("UserId");
				String accountId = request.getParameter("accountId");
				String tmp = request.getParameter("valplus");
				double value;
				if(tmp == null)
				{
					tmp = request.getParameter("valminus");
					
					if(tmp == null)
					{
						request.setAttribute("error","error");
						response.sendRedirect(String.format("/AntonBanking/MyTransactionServlet?userId=%s&accountId=%s",userid,accountId));
					}
					else value = - Double.valueOf(tmp);
				}
				value = Double.valueOf(tmp);
				MainService.AddTransaction(accountId,value);				
				response.sendRedirect(String.format("/AntonBanking/MyTransactionServlet?userId=%s&accountId=%s",userid,accountId));
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
