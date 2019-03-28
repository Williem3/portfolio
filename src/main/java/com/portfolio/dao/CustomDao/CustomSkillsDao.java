package com.portfolio.dao.CustomDao;

import com.portfolio.entity.Skills;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomSkillsDao {

    @Query("SELECT logo from Skills")
    List<byte[]> findLogos();

    @Query("SELECT logo from Skills where id=:id")
    Skills get(int id);
}
