package com.portfolio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/portfolio")
    public String showPortfolio() {
        return "portfolio";
    }

    @RequestMapping("/technology")
    public String showSkills() {
        return "technology";
    }

    @RequestMapping("/resume")
    public String showResume() {
        return "resume";
    }
}
