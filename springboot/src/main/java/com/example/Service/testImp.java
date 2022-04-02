package com.example.Service;

import com.example.Dao.test;
import com.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class testImp {
    @Autowired
    test test;
    public List<User> selectUser(){
        return test.selectUser();
    }
}
