package com.example.service;


import com.example.pojo.ResultMap;
import com.example.pojo.User;
import com.example.vo.LoginUser;

import javax.xml.transform.Result;

public interface UserService {

    void insert(String userId,LoginUser loginUser);

    User getById(String userId);

    void update(User user);
}
