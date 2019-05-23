package com.portfolio.controller;

import com.portfolio.Service.ResumeService;
import com.portfolio.Service.SkillsService;
import com.portfolio.Service.UserService;
import com.portfolio.entity.Resume;
import com.portfolio.entity.Skills;
import com.portfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    // Post mapping to add a skill with name and logo file.
    @PostMapping("/technologyList")
    public String uploadMultipartFile(@RequestParam("logo") MultipartFile file, @RequestParam("techName")String techName) {
        User user = userService.findByUsername("wmangram");
        try {
            // save file to MySQL, use utilize
            // .getBytes() from MultipartFile object to assign to our Skill object before passing to DAO
            Skills newSkill = new Skills(techName, file.getBytes(), user);
            skillsService.createTechnology(newSkill);
            return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
        } catch (Exception e) {
            return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
        }
    }

    // Delete Mapping for removing a skill from the list of skills to be display at williemangram.com/technology
    @DeleteMapping("/technologyList/{id}")
    public String deleteSkill(@PathVariable("id") long id) {
        skillsService.deleteSkill(id);

        return "Skill deleted successfully!";
    }

    // mapping to display all the users saved in the database
    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.findUserList();
    }

    // post mapping to create a user
    @PostMapping(value="/users")
    public void createUser(User user){
        user.setId(0);
        userService.save(user);

    }

    @GetMapping("/resumeForm")
    public Resume getResume() {
        return resumeService.getResume(1);
    }

    // same method from uploadMultipartFile to update resume with a new file. Never creates a new one.
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
