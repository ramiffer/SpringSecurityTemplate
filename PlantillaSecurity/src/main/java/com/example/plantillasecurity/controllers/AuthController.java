package com.example.plantillasecurity.controllers;

import com.example.plantillasecurity.models.User;
import com.example.plantillasecurity.services.UserService;
import com.example.plantillasecurity.validator.UserValidator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    private final UserService userService;
    private final UserValidator userValidator;

    public AuthController(UserService userService,
                          UserValidator userValidator){
        this.userService = userService;
        this.userValidator = userValidator;
    }

    //Index

    @GetMapping("/index")
    public String indexPage(){
        return "indexPage";
    }

    //Registration

    @GetMapping("/registration")
    public String registerUser(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/registration")
    public String processRegistration(@ModelAttribute("user")@Valid User user, BindingResult result) {

        userValidator.validate(user, result);

        if (result.hasErrors()) {
            return "registerForm";
        }
        userService.createUser(user);

        return "redirect:/index";
    }


    //Login

    @GetMapping("/login")
    public String loginUser(HttpSession session, Model model){

        if(session.getAttribute("username") != null) {
            model.addAttribute("username", session.getAttribute("username"));
            session.removeAttribute("username");
        }

        return "loginForm";
    }

}
