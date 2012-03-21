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

    @RequestMapping(value = "/MyTransactionServlet/{userID}/{AccountID}", method = RequestMethod.GET)
    public ModelAndView showTransactions(@PathVariable int userID, @PathVariable int AccountID, HttpSession session) throws ServletException, IOException
    {

        String usr_name = MainService.getUserName(userID);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("mytransactions");
        mav.addObject("ATMTransactions", MainService.getAllMyTransactions(AccountID));
        mav.addObject("ATMUserName", usr_name);
        mav.addObject("ATMCurrencyName", MainService.getAccountCurrencyName(AccountID));
        mav.addObject("formTransaction", new MyTransaction(12));
        session.setAttribute("ATMAccountID", String.valueOf(AccountID));
        session.setAttribute("HiddenUserID", userID);
        return mav;
    }

    @RequestMapping(value = "/MyTransactionServlet/AddMoneyServlet", method = RequestMethod.POST)
    public String AddMoney(@ModelAttribute("formTransaction") MyTransaction transaction, BindingResult result, HttpSession session)
    {
        String accountID = (String) session.getAttribute("ATMAccountID");
        MainService.updateAccount(Integer.valueOf(accountID), transaction);
        return String.format("redirect:/MyTransactionServlet/%s/%s", session.getAttribute("HiddenUserID").toString(), accountID);
    }

    @RequestMapping(value = "/MyTransactionServlet/TakeMoneyServlet", method = RequestMethod.POST)
    public String TakeMoney(@ModelAttribute("formTransaction") MyTransaction transaction, BindingResult result, HttpSession session)
    {
        String accountID = (String) session.getAttribute("ATMAccountID");
        transaction.makeNegative();
        MainService.updateAccount(Integer.valueOf(accountID), transaction);
        return String.format("redirect:/MyTransactionServlet/%s/%s", session.getAttribute("HiddenUserID").toString(), accountID);
    }
}
