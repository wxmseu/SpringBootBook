package com.wxm.springbootbook.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.wxm.springbootbook.User;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;

@RestController
public class ParamController {

    @GetMapping("/noannotation")
    public User noAnnotation(User user){
        return user;
    }

    @GetMapping("requestparam")
    public User requestParam(@RequestParam String name){
        if (name.isBlank()){
            name = "jdq";
        }
        User user = new User();
        user.setName(name);
        return user;
    }

    @GetMapping("/pathvariable/{name}/{age}")
    public User pathVariable(@PathVariable String name, @PathVariable int age){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("requestbody")
    public User requestBody(@RequestBody @Valid User user){
        return user;
    }
}
