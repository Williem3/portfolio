package com.portfolio.Service.Impl;

import com.portfolio.Service.ResumeService;
import com.portfolio.dao.ResumeDao;
import com.portfolio.entity.Resume;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public Resume findById(long id) {
        return resumeDao.findById(id);
    }

    public Resume updateResume(Resume resume) {

        return resumeDao.save(resume);
    }

    public Resume getResume() {
        return resumeDao.findById(1);
    }
}
