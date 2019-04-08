package com.portfolio.dao;

import com.portfolio.dao.CustomDao.CustomSkillsDao;
import com.portfolio.entity.Resume;
import org.springframework.data.repository.CrudRepository;

public interface ResumeDao extends CrudRepository<Resume, Long>, CustomSkillsDao {

    @Override
    Resume findById(long id);
}
