package com.portfolio.controller;

import com.google.common.primitives.Bytes;
import com.portfolio.Service.SkillsService;
import com.portfolio.Service.UserService;
import com.portfolio.entity.Skills;
import com.portfolio.entity.User;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private SkillsService skillsService;


    @RequestMapping("/home")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/portfolio")
    public String showPortfolio() {
        return "portfolio";
    }

    @GetMapping(value = "/technology")
    public String technologyList(Model theModel) throws IOException {
        User user = userService.findByUsername("wmangram");
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

        System.out.println("\\\nThis is the base64 called for: " + base64List);

        /*for (int j = 0; j < base64List.size(); j++) {
            theModel.addAttribute("userImage", base64List.get(j));
            System.out.println("\\\nThis is the base64 called for: " + base64List.get(j));
        }*/
        /*for (int j = 0; j < logo.size(); j++) {
            theModel.addAttribute("logo", logo.get(j));
            System.out.println("\\\nThis is the logo called for: " + logo.get(j));
        }
        theModel.addAttribute("logo", logo);
        */



        return "technology";
    }
    @RequestMapping("/resume")
    public String showResume() {
        return "resume";
    }

}
