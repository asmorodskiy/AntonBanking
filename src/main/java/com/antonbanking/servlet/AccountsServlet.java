package com.antonbanking.servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.antonbanking.business.Account;
import com.antonbanking.business.CurrencyType;
import com.antonbanking.service.MainService;

@Controller
@SessionAttributes
public class AccountsServlet
{
    @RequestMapping(value = "/AccountsServlet/{userID}", method = RequestMethod.GET)
    public ModelAndView showAccounts(@PathVariable int userID, HttpSession session)
    {
        ArrayList<String> to_jsp = new ArrayList<String>();
        CurrencyType[] currency_arr = CurrencyType.values();
        for (CurrencyType val1 : currency_arr)
            to_jsp.add(val1.getName());
        String usr_name = MainService.getUserName(userID);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("accounts");
        mav.addObject("ATMAccounts", MainService.getAllAccounts(userID));
        mav.addObject("ATMCurrencyTypes", to_jsp);
        mav.addObject("ATMUserName", usr_name);
        session.setAttribute("HiddenUserID", userID);
        mav.addObject("account", new Account());
        return mav;
    }

    @RequestMapping(value = "/AccountsServlet/AddAccountServlet", method = RequestMethod.POST)
    public String AddAccount(@ModelAttribute("account") Account account, BindingResult result, HttpSession session)
    {
        MainService.AddAccount(session.getAttribute("HiddenUserID").toString(), account);
        return String.format("redirect:/AccountsServlet/%s", session.getAttribute("HiddenUserID").toString());
        //return "redirect:/"; 
    }

}
