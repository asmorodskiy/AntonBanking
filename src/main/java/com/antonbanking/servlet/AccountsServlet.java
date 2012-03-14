package com.antonbanking.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antonbanking.business.CurrencyType;
import com.antonbanking.hibernate.UserDB;
import com.antonbanking.service.MainService;

@Controller
public class AccountsServlet
{

    private UserDB userDB;

    @RequestMapping
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);
        if (session != null)
        {
            int userId = Integer.valueOf(request.getParameter("ATMUserID"));
            ArrayList<String> to_jsp = new ArrayList<String>();
            CurrencyType[] currency_arr = CurrencyType.values();
            for (CurrencyType val1 : currency_arr)
                to_jsp.add(val1.getName());
            String usr_name = MainService.getUserName(userId, userDB);
            request.setAttribute("ATMAccounts", MainService.getAllAccounts(userId, userDB));
            request.setAttribute("ATMCurrencyTypes", to_jsp);
            request.setAttribute("ATMUserName", usr_name);

            session.setAttribute("ATMUserID", request.getParameter("ATMUserID"));

            request.getRequestDispatcher("accounts.jsp").forward(request, response);
        }
    }

}
