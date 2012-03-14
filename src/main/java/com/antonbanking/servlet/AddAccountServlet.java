package com.antonbanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.antonbanking.hibernate.UserDB;
import com.antonbanking.service.MainService;

public class AddAccountServlet extends HttpServlet
{

    private UserDB userDB;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession session = request.getSession(false);
        if (session != null)
        {
            String userid = (String) session.getAttribute("ATMUserID");
            MainService.AddAccount(userid, (String) request.getParameter("CurrencyTypes"), request.getParameter("ATMQuantity"), userDB);
            response.sendRedirect(String.format("/AntonBanking/AccountsServlet?ATMUserID=%s", userid));
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
