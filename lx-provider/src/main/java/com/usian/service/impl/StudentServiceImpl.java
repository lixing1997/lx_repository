package com.usian.service.impl;

import com.usian.pojo.Student;
import com.usian.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStudentById(Integer id) {
        Student s = new Student();
        s.setId(555);
        s.setName("hello provider");
        return s;
    }
}
