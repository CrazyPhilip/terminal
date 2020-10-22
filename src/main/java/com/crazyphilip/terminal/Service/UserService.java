package com.crazyphilip.terminal.Service;

import com.crazyphilip.terminal.entity.User;
import com.crazyphilip.terminal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectUsers(String uid){
        return userMapper.selectUsers(uid);
    }

    public int checkUser(User user){
        return userMapper.checkUser(user);
    }

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }
}
