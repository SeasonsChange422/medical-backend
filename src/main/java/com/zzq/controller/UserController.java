package com.zzq.controller;

import com.zzq.common.Result;
import com.zzq.entity.LoginUser;
import com.zzq.entity.User;
import com.zzq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author dhx
 * @date 2025/1/16 22:33
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/user/register")
    public Result register(@RequestBody LoginUser loginUser){
        return userService.register(loginUser);
    }

    @PostMapping("/api/user/login")
    public Result login(@RequestBody LoginUser loginUser){
        return userService.login(loginUser);
    }

    @PostMapping("/api/user/update")
    public Result updateInfo(@RequestBody User user){
        return userService.updateInfo(user);
    }

    @GetMapping("/api/user/getInfo")
    public Result getInfo(@RequestHeader("token") String token){
        return userService.getInfo(token);
    }

    @PostMapping("/api/user/logout")
    public Result logout(@RequestHeader("token")String token){
        return userService.logout(token);
    }
}
