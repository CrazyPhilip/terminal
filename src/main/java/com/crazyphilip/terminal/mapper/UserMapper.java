package com.crazyphilip.terminal.mapper;

import com.crazyphilip.terminal.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectUsers(String uid);

    int checkUser(User user);

    int insertUser(User user);
}
