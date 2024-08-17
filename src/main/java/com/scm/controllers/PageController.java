package com.scm.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController 
{
    @Autowired
    private UserService userService;

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
    public String register(Model model)
    {
        UserForm userForm = new UserForm();
        //can send default data too
        // userForm.setName("Sayli Jogi");
        // userForm.setEmail("saylijogi@gmail.com");
        // userForm.setPassword("Sayli123");
        // userForm.setAbout("This is writing somthing about yourself");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //called register
 
    @RequestMapping(value="/do-register",method=RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm,BindingResult rBindingResult, HttpSession session) 
    {
        System.out.println("Processing registration...");
        //fetch form data
        //userform
        System.out.println(userForm);
        //validate form data
        if(rBindingResult.hasErrors()){
            return "register";
        }
        //save user data to database
        
        //userservice
        
        //Userform --> usermapper
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePicture("\"C:\\Users\\Sayli\\Downloads\\vecteezy_user-profile-icon-profile-avatar-user-icon-male-icon_20911748.png\"")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("C:\\Users\\Sayli\\Downloads\\vecteezy_user-profile-icon-profile-avatar-user-icon-male-icon_20911748.png");
        

        User savedUser = userService.saveUser(user);
        System.out.println("User Saved : ");

        //add the message

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message",message);

        //redirect to login page
        return "redirect:/register";
    }
    
}