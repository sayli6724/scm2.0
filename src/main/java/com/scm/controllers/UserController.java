package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    //user dashboard page

    @RequestMapping(value="/dashboard")
    public String userDashboard() {
        System.out.println("User dashboard page");
        return "user/dashboard";
    }

    //user profile page

    @RequestMapping(value="/profile")
    public String userProfile() {
        System.out.println("User profile page");
        return "user/profile";
    }
    
    //user addcontact page

    //user viewcontact

    //user editcontact page

    //user delete contact page

}
