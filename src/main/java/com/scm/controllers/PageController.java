package com.scm.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController 
{

    @RequestMapping("/home")
    public String home(Model model) 
    {
        {
            System.out.println("Home Page Handler");
            //sending data to view
            model.addAttribute("name", "MET-IIT");
            model.addAttribute("location","Bandra, Mumbai");
            model.addAttribute("clgsite","https://www.met.edu/institute/institute_of_information_technology");
            return "home";
        }
    }

    //about route

    @RequestMapping("/about")
    public String aboutPage(Model model)
    {
        model.addAttribute("isLogin", true);
        System.out.println("About Page Loading");
        return "about";
    }

    //services

    @RequestMapping("/services")
    public String servicesPage()
    {
        System.out.println("About Page Loading");
        return "services";
    }
    
    //contact
    @GetMapping("/contact")
    public String contact() 
    {
        return new String("contact");
    }

    @GetMapping("login")
    public String login() 
    {
        return new String("login");
    }
    
    @GetMapping("/register")
    public String signuo()
    {
        return "register";
    }
    
}