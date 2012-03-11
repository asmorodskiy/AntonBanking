package com.antonbanking.servlet;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.antonbanking.hibernate.UserDB;
import com.antonbanking.service.MainService;

// store userid in context of session

@Controller
public class AdminServlet {

    @Autowired
    private UserDB userDB;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ShowAllUsers(Model model) throws ClassNotFoundException,
	    SQLException {

	model.addAttribute("ATMUsers", MainService.getAllUsers(userDB));
	return "index";
    }

    @RequestMapping(method = RequestMethod.POST, params = "new")
    public String AddUser(Model model,
	    @RequestParam("ATMNewUser") String NewUser) {
	boolean passed = true;
	passed = StringUtils.isNotBlank(NewUser);
	if (passed)
	    passed = MainService.AddUser(NewUser, userDB);
	return "/AntonBanking/Users";
    }

}
