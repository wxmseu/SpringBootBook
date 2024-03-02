package com.wxm.springbootbook.service.impl;

import com.wxm.springbootbook.entity.Student;
import com.wxm.springbootbook.mapper.StudentMapper;
import com.wxm.springbootbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudentAll(){
        return studentMapper.getStudentAll();
    }

    @Override
    public Student getStudentById(String name){
        return studentMapper.getStudentById(name);

    }
}
