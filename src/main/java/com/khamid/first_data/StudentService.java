package com.khamid.first_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity create(StudentEntity entity) {
        studentRepository.save(entity);
        return entity;
    }
}