package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Service
public class LoginService {
    @Resource
    UserDao userDao;
    public User login(User user){
        return userDao.selectUserByname(user);

    }
}
