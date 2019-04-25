package com.portfolio.controller;

import com.portfolio.Service.ResumeService;
import com.portfolio.Service.SkillsService;
import com.portfolio.Service.UserService;
import com.portfolio.entity.Resume;
import com.portfolio.entity.Skills;
import com.portfolio.entity.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RESTController {

    @Autowired
    private SkillsService skillsService;
    @Autowired
    private UserService userService;
    @Autowired
    private ResumeService resumeService;

    @GetMapping("/technologyList")
    public List<Skills> getSkills() {
        return skillsService.getSkills();
    }

    @PostMapping("/technologyList")
    public String uploadMultipartFile(@RequestParam("logo") MultipartFile file, @RequestParam("techName")String techName) {
        User user = userService.findByUsername("wmangram");
        try {
            // save file to MySQL
            Skills newSkill = new Skills(techName, file.getBytes(), user);
            skillsService.createTechnology(newSkill);
            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
        } catch (Exception e) {
            return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
        }
    }
    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.findUserList();
    }

    @PostMapping(value="/users")
    public void createUser(User user){
        user.setId(0);
        userService.save(user);

    }

    @GetMapping("/resumeForm")
    public Resume getResume() {
        return resumeService.getResume(1);
    }


    @PostMapping("/resumeForm/update")
    public String uploadResume(@RequestParam("resume") MultipartFile file) {
        try {
            // save file to MySQL
            Resume resume = new Resume();
            resume.setId(1);
            resume.setFile(file.getBytes());
            resumeService.updateResume(resume);
            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
        } catch (Exception e) {
            return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
        }
    }

}
