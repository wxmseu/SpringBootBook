package com.wxm.springbootbook.mapper;

import com.wxm.springbootbook.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StudentMapper{
    List<Student> getStudentAll();

    Student getStudentById(@Param("name") String name);
}
