package com.antonbanking.servlet;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.antonbanking.business.User;

@Controller
@RequestMapping("/auth")
public class LoginLogoutServlet
{

    /**
     * Handles and retrieves the login JSP page
     * 
     * @return the name of the JSP page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@ModelAttribute("user") @Valid User user, BindingResult result)
    {
        return "login";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String getDeniedPage()
    {
        return "deniedpage";
    }
}
