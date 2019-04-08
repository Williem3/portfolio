package com.portfolio.controller;

import com.portfolio.Service.ResumeService;
import com.portfolio.Service.SkillsService;
import com.portfolio.Service.UserService;
import com.portfolio.entity.Resume;
import com.portfolio.entity.Skills;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private SkillsService skillsService;

    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/home")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/portfolio")
    public String showPortfolio(Model theModel) throws IOException {


        return "portfolio";
    }

    @GetMapping(value = "/technology")
    public String technologyList(Model theModel) throws IOException {
        List<Skills> userSkillsList = skillsService.findSkillList("wmangram");

        List<byte[]> logo = skillsService.findLogos();
        List<String> base64List = new ArrayList<>();

        for (int i = 0; i < logo.size(); i++) {
            byte[] encodeBase64 = Base64.encodeBase64(logo.get(i));
            String base64Encoded = new String(encodeBase64, "UTF-8");
            base64List.add(base64Encoded);
        }
        theModel.addAttribute("userSkills", userSkillsList);
        theModel.addAttribute("userImages", base64List);


        return "technology";
    }


    @RequestMapping("/resume")
    public String showResume(Model theModel) throws IOException {
        Resume resumeInfo = resumeService.findById(1);

        byte[] encodeBase64 = Base64.encodeBase64(resumeInfo.getFile());
        String base64Encoded = new String(encodeBase64, "UTF-8");


        theModel.addAttribute("resume", base64Encoded);
        theModel.addAttribute("resumeInfo", resumeInfo);

        return "resume";
    }

}
