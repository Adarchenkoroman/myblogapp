package com.blogapplication.myblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/greeting")
    public String greeting(Model model) {

        model.addAttribute("title" , "Страница про нас");
        return "home";
    }


    @GetMapping("/about")
    public String about(Model model) {

        model.addAttribute("title", "Главная страница");
        return "about";
    }
}