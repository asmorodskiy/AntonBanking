package com.antonbanking.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.antonbanking.business.MyTransaction;
import com.antonbanking.service.MainService;

@Controller
@SessionAttributes
public class MyTransactionServlet
{
    private ModelAndView getModelAndView(int userID, int accountID, HttpSession session, MyTransaction transaction)
    {
        String usr_name = MainService.getUserName(userID);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mytransactions");
        mav.addObject("ATMTransactions", MainService.getAllMyTransactions(accountID));
        mav.addObject("ATMUserName", usr_name);
        mav.addObject("ATMCurrencyName", MainService.getAccountCurrencyName(accountID));
        mav.addObject("formTransaction", transaction);
        session.setAttribute("ATMAccountID", String.valueOf(accountID));
        session.setAttribute("HiddenUserID", userID);
        return mav;
    }

    @RequestMapping(value = "/MyTransactionServlet/{userID}/{AccountID}", method = RequestMethod.GET)
    public ModelAndView showTransactions(@PathVariable int userID, @PathVariable int AccountID, HttpSession session) throws ServletException, IOException
    {
        return getModelAndView(userID, AccountID, session, new MyTransaction(12));
    }

    @RequestMapping(value = "/MyTransactionServlet/AddMoneyServlet", method = RequestMethod.POST)
    public ModelAndView AddMoney(@ModelAttribute("formTransaction") MyTransaction transaction, BindingResult result, HttpSession session)
    {
        MyTransaction transactionForView;
        String accountID = (String) session.getAttribute("ATMAccountID");
        if (result.hasErrors())
            transactionForView = transaction;
        else
        {
            transactionForView = new MyTransaction(12);
            MainService.updateAccount(Integer.valueOf(accountID), transaction);
        }
        return getModelAndView(Integer.valueOf(session.getAttribute("HiddenUserID").toString()), Integer.valueOf(accountID), session, transactionForView);
    }

    @RequestMapping(value = "/MyTransactionServlet/TakeMoneyServlet", method = RequestMethod.POST)
    public ModelAndView TakeMoney(@ModelAttribute("formTransaction") MyTransaction transaction, BindingResult result, HttpSession session)
    {
        MyTransaction transactionForView;
        String accountID = (String) session.getAttribute("ATMAccountID");
        if (result.hasErrors())
            transactionForView = transaction;
        else
        {
            transactionForView = new MyTransaction(12);
            transaction.makeNegative();
            MainService.updateAccount(Integer.valueOf(accountID), transaction);
        }
        return getModelAndView(Integer.valueOf(session.getAttribute("HiddenUserID").toString()), Integer.valueOf(accountID), session, transactionForView);
    }
}
