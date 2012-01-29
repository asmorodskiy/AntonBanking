package com.antonbanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.antonbanking.service.MainService;
import org.apache.commons.lang.StringUtils;

public class AddUserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5124157447188342797L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			boolean passed = true;
			String NewUser = request.getParameter("NewUser");
			passed =  StringUtils.isNotBlank(NewUser);
			if(passed) passed=MainService.AddUser(NewUser);
			if(!passed) response.sendRedirect("/AntonBanking/AdminServlet?error=error!");
			response.sendRedirect("/AntonBanking/AdminServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
