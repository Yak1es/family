package com.example.Dao;

import com.example.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface test {
    List<User> selectUser();
}
