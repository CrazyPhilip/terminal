package com.crazyphilip.terminal.controller;

import com.alibaba.fastjson.JSONObject;
import com.crazyphilip.terminal.Service.TokenService;
import com.crazyphilip.terminal.Service.UserService;
import com.crazyphilip.terminal.annotation.UserLoginToken;
import com.crazyphilip.terminal.entity.User;
import com.crazyphilip.terminal.util.ReturnCode;
import com.crazyphilip.terminal.util.ReturnVO;
import com.crazyphilip.terminal.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("User")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/Login")
    public ReturnVO login(@RequestBody User user, HttpServletResponse response){
        List<User> list = userService.selectUsers(user.getUid());

        if (list.size() == 1 && list.get(0).getPassword().equals(user.getPassword())){
            String token = tokenService.getToken(user);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token", token);
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            response.addCookie(cookie);
            return new ReturnVO(ReturnCode.SUCCESS, "登录成功", jsonObject);
        }
        else {
            return new ReturnVO(ReturnCode.FAIL, "登录失败");
        }
    }

    @UserLoginToken
    @PostMapping("/getUserInfo")
    public ReturnVO getUserInfo(){
        String uid = TokenUtil.getTokenUid();
        List<User> list = userService.selectUsers(uid);

        if (list.size() == 1){
            return new ReturnVO(ReturnCode.SUCCESS, "获取成功", list.get(0));
        }
        else {
            return new ReturnVO(ReturnCode.FAIL, "获取失败");
        }
    }

    /*
    @PostMapping("/Register")
    public ReturnVO Register(@RequestBody User user){
        int count = userService.insertUser(user);

        if (count == 1){
            return new ReturnVO()
        }
    }*/
}
