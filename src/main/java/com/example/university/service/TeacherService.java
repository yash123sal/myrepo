package com.example.university.service;

import com.example.university.entity.Result;
import com.example.university.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private ResultRepository resultRepository;

    public Result addMarks(Result result){
        return resultRepository.save(result);
    }

}