package com.portfolio.dao;

import com.portfolio.dao.CustomDao.CustomSkillsDao;
import com.portfolio.entity.Skills;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkillsDao extends CrudRepository<Skills, Long>, CustomSkillsDao {


    List<Skills> findAll();

    @Override
    List<byte[]> findLogos();

    @Override
    Skills get(int id);
}
