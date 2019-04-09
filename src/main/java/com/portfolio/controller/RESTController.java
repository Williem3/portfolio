package com.portfolio.controller;

import com.portfolio.Service.ResumeService;
import com.portfolio.Service.SkillsService;
import com.portfolio.Service.UserService;
import com.portfolio.entity.Resume;
import com.portfolio.entity.Skills;
import com.portfolio.entity.User;
import org.apache.commons.codec.binary.Base64;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public Skills createTechnology(@RequestBody Skills skills) {
        User user = userService.findByUsername("wmangram");

        skills.setUser(user);
        skills.setId(0);

        skillsService.createTechnology(skills);

        return skills;
    }

    @GetMapping("/resumeForm")
    public Resume getResume() {

        return resumeService.getResume();
    }

    @PostMapping("/resumeForm/update")
    public Resume updateResume(@RequestBody Resume resume) {

        resume.setId(1);
        resumeService.updateResume(resume);

        return resume;
    }
}
