package com.example.plantillasecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequestMapping("home")
public class AppController {

    @GetMapping("")
    public String home(Principal principal, Model model){
        if(principal != null){
            String username = principal.getName();
            model.addAttribute("username", username);
            return "homePage";
        }
    return "redirect:/login";
    }


}
