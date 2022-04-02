package com.example.Service.Personal;

import com.example.Dao.Personal.PersonalLogin;
import com.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalLoginServiceImp implements PersonalLoginService {

    @Autowired
    PersonalLogin personalLogin;

    @Override
    public String Login(User user) {
        return personalLogin.Login(user);
    }
}
