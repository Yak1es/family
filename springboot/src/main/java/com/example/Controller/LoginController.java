package com.example.Controller;

import com.example.Entity.User;
import com.example.Service.Personal.PersonalLoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    PersonalLoginServiceImp personalLoginServiceImp;

    @PostMapping("/UserLogin")
    public String LoginUser(@RequestBody User user) {
        System.out.println(personalLoginServiceImp.Login(user));
        return personalLoginServiceImp.Login(user);
    }
}
