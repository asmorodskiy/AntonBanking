package com.antonbanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.antonbanking.hibernate.AccountDB;
import com.antonbanking.hibernate.UserDB;
import com.antonbanking.service.MainService;

public class MyTransactionServlet extends HttpServlet
{

    private UserDB userDB;

    private AccountDB accountDB;

    private static final long serialVersionUID = 9142114737047146060L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        HttpSession session = request.getSession(false);
        if (session != null)
        {
            int userId = Integer.valueOf((String) session.getAttribute("ATMUserID"));
            String usr_name = MainService.getUserName(userId, userDB);
            int account_id = Integer.valueOf(request.getParameter("ATMAccountID"));
            request.setAttribute("ATMTransactions", MainService.getAllMyTransactions(account_id, accountDB));
            request.setAttribute("ATMUserName", usr_name);
            request.setAttribute("ATMCurrencyName", MainService.getAccountCurrencyName(account_id, accountDB));

            session.setAttribute("ATMAccountID", String.valueOf(account_id));

            request.getRequestDispatcher("mytransactions.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
