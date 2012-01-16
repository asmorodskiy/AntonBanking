package com.antonbanking.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	class User {
		
		public int id;
		public String name;
		public User(int id,String name)
		{
			this.id=id;
			this.name=name;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<User> lst = new ArrayList<User>();
		lst.add(new User(1,"Name"));
		lst.add(new User(2,"Name2"));
		lst.add(new User(3,"Name3"));
		request.setAttribute("Users",lst);
		request.setAttribute("Test1","TestText");
		request.getRequestDispatcher("index.jsp").forward(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
