package com.wxm.springbootbook.service;

import com.wxm.springbootbook.entity.Student;

import java.util.List;

public interface UserService {
    List<Student> getStudentAll();

    Student getStudentById(String name);
}
