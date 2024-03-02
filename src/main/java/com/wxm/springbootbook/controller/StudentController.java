package com.wxm.springbootbook.controller;

import com.wxm.springbootbook.entity.Student;
import com.wxm.springbootbook.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public UserServiceImpl userService;

    @GetMapping("/student")
    public List<Student> student(){

        return userService.getStudentAll();
    }

    @GetMapping("/student/{name}")
    public Student studentById(@PathVariable String name){
        Student student = userService.getStudentById(name);
        if (student == null){
            return new Student();
        } else {
            return student;
        }
    }
}
