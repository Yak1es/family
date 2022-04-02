package com.example.Controller;

import com.example.Entity.User;
import com.example.Service.testImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    testImp test;
    @RequestMapping("/test")
    public List<User> selectTest(){
        return test.selectUser();
    }
}
