package com.portfolio.Service;

import com.portfolio.entity.Skills;

import java.util.List;

public interface SkillsService {
    List<Skills> findSkillList(String wmangram);

    List<byte[]> findLogos();

    Skills get(int id);
}
