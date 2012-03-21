package com.antonbanking.servlet;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.antonbanking.business.User;
import com.antonbanking.service.MainService;

@Controller
@SessionAttributes
public class AdminServlet
{

    @Autowired
    private Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(validator);
    }

    @RequestMapping(value = "/")
    public ModelAndView showUsers() throws ClassNotFoundException, SQLException
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("ATMUsers", MainService.getAllUsers());
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public String AddUser(@ModelAttribute("user") @Valid User user, BindingResult result)
    {
        if (!result.hasErrors())
            MainService.AddUser(user);
        return "redirect:/";
    }

}
