package com.example.Dao.Personal;

import com.example.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalLogin {
    String Login(User user);
}
