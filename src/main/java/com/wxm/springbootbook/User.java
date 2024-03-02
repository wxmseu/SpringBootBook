package com.wxm.springbootbook;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.util.Locale;

@Data
public class User {
    @NotBlank(message = "名字不能为空")
    private String name;


    @Min(value = 1, message = "年齡不能小於1")
    private int age;

    @Email(message = "E-mail格式不正確")
    private String email;

}
