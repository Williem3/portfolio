package com.portfolio.Service.Impl;

import com.portfolio.Service.SkillsService;
import com.portfolio.Service.UserService;
import com.portfolio.dao.CustomDao.CustomSkillsDao;
import com.portfolio.dao.SkillsDao;
import com.portfolio.entity.Skills;
import com.portfolio.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillsService {

    @Autowired
    private SkillsDao skillsDao;

    @Autowired
    private UserService userService;

    public List<Skills> findSkillList(String username) {
        User user = userService.findByUsername(username);
        List<Skills> skillsList = user.getUserSkills();

        return skillsList;
    }

    public List<byte[]> findLogos() {
        return skillsDao.findLogos();
    }

    public Skills get(int id) {
        return skillsDao.get(id);
    }
}
