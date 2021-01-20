package com.usian.controller;

import com.usian.pojo.Student;
import com.usian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/getUser/{id}")
    public Student getUser(@PathVariable("id") Integer id){
        System.out.println("=================");
        return studentService.getStudentById(id);
    }
}
