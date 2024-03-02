package com.wxm.springbootbook.entity;

import lombok.Data;

@Data
//表名与实体类名称不一致需要手动指定表名
public class Student {
    private Integer id;
    private String name;
    private Integer sex;
    private Integer age;
    private String grade;
}
