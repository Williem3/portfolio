package com.portfolio.Service;

import com.portfolio.entity.Resume;

public interface ResumeService {
    Resume findById(long id);

    Resume updateResume(Resume resume);

    Resume getResume(long id);


}
