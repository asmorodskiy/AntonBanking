package com.antonbanking.servlet;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.antonbanking.business.User;
import com.antonbanking.hibernate.UserDB;
import com.antonbanking.service.MainService;

@Controller
public class AdminServlet
{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ShowAllUsers(Model model) throws ClassNotFoundException, SQLException
    {
        UserDB userDB = new UserDB();
        model.addAttribute("ATMUsers", MainService.getAllUsers(userDB));
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value = "AddUser.html")
    public String AddUser(User user, BindingResult result, Map model)
    {
        UserDB userDB = new UserDB();
        MainService.AddUser(user.getName(), userDB);

        return "index";
    }

}
