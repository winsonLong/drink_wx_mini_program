package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public void insert(String userId, LoginUser loginUser) {
        User user=new User();
        user.setUserid(userId);
        user.setAvartar(loginUser.getAvartar());
        user.setCity(loginUser.getCity());
        user.setNickname(loginUser.getNickname());
        user.setProvince(loginUser.getProvince());
        userMapper.insert(user);
    }

    @Override
    public User getById(String userId) {
        User user=userMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }
}
