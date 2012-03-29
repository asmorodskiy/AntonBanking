package com.antonbanking.servlet;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.antonbanking.business.User;
import com.antonbanking.service.MainService;

@Controller
@SessionAttributes("user")
public class AdminServlet
{

    private ModelAndView getModelAndView(User user)
    {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("ATMUsers", MainService.getAllUsers());
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/")
    public ModelAndView showUsers()
    {
        return getModelAndView(new User());
    }

    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public ModelAndView AddUser(@ModelAttribute("user") @Valid User user, BindingResult result)
    {
        User userForView;
        if (result.hasErrors())
            userForView = user;
        else
        {
            userForView = new User();
            MainService.AddUser(user);
        }
        return getModelAndView(userForView);
    }

}
