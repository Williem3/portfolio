package com.portfolio.controller;

import com.portfolio.Service.ResumeService;
import com.portfolio.Service.SkillsService;
import com.portfolio.Service.UserService;
import com.portfolio.entity.Resume;
import com.portfolio.entity.Skills;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
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

    // mapping to display the index(homepage)
    @RequestMapping("/home")
    public String showHome() {
        return "index";
    }

    // mapping to display the portfolio.html web page
    @RequestMapping("/portfolio")
    public String showPortfolio(Model theModel) throws IOException {


        return "portfolio";
    }

    // Mapping to display the skills list.
    @GetMapping(value = "/technology")
    public String technologyList(Model theModel) throws IOException {

        try {
            // separate list to get the skill names
            List<Skills> userSkillsList = skillsService.findSkillList("wmangram");

            // separate list to get the skill logos
            List<byte[]> logo = skillsService.findLogos();
            // new list to input the logos base64 encoding
            List<String> base64List = new ArrayList<>();

            // for (nested if else) statement to check whether the logo in the list is already Base64 encoded.
            // if it is then it will add it to the base64 list, if not it will do the conversion.
            for (int i = 0; i < logo.size(); i++) {
                if (Base64.isBase64(logo.get(i))) {
                    String base64Encoded = new String((logo.get(i)), "UTF-8");
                    base64List.add(base64Encoded);
                }
                else {
                    byte[] encodeBase64 = Base64.encodeBase64(logo.get(i));
                    String base64Encoded = new String(encodeBase64, "UTF-8");
                    base64List.add(base64Encoded);
                }
            }

            theModel.addAttribute("userSkills", userSkillsList);
            theModel.addAttribute("userImages", base64List);

            return "technology";
        }
        catch (NullPointerException nexc) {
            return "nullexception";
        }
    }

    // Mapping to get the resume file to display on the HTML page
    @GetMapping("/resume")
    public String showResume(Model theModel) throws IOException {
        Resume resumeInfo = resumeService.findById(1);

        byte[] encodeBase64 = Base64.encodeBase64(resumeInfo.getFile());
        String base64Encoded = new String(encodeBase64, "UTF-8");


        theModel.addAttribute("resume", base64Encoded);

        return "resume";
    }


    // Get mapping to provide download function to the resume page
    @GetMapping("/resume/download/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("fileId") long fileId) {
        Resume resumeFile = resumeService.findById(fileId);


        byte[] buffer = resumeFile.getFile();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "image/jpeg");
        headers.set("Content-Disposition", "attachment; filename=\"" + "wmangramResume" + ".jpg\"");
        return new ResponseEntity<byte[]>(buffer, headers, HttpStatus.OK);
    }


    // Mappings to go to the management web pages
    @GetMapping("/manage")
    public String managerUsers() {
        return "addUser";
    }

    @GetMapping("/manageTech")
    public String manageTech() {
        return "uploadfile";
    }

    @GetMapping("/manageResume")
    public String manageResume() {
        return "uploadResume";
    }


    // remove default spring favicon
    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {

    }
}
