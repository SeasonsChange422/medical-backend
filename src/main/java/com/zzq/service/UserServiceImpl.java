package com.zzq.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.LoginUser;
import com.zzq.entity.User;
import com.zzq.mapper.UserMapper;
import com.zzq.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dhx
 * @date 2025/1/16 22:16
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(LoginUser loginUser) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username",loginUser.getUsername()).eq("password",loginUser.getPassword()));
        if(user == null){
            return Result.errorResult(AppHttpCodeEnum.LOGIN_ERROR);
        }
        return Result.okResult(JwtUtil.generateToken(user.getId()));
    }

    @Override
    public Result register(LoginUser loginUser) {
        if(userMapper.selectOne(new QueryWrapper<User>().eq("username",loginUser.getUsername()))!=null){
            return Result.errorResult(AppHttpCodeEnum.USERNAME_EXIST);
        }userMapper.insert(new User(loginUser.getUsername(), loginUser.getPassword()));
        return Result.okResult(200,"注册成功");
    }

    @Override
    public Result updateInfo(User user) {
        if(userMapper.updateById(user)==0){
            return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
        }
        return Result.okResult(200,"修改成功");
    }

    @Override
    public Result logout(String token) {
        if(!JwtUtil.validateToken(token)){
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        return Result.okResult(200,"注销成功");
    }

    @Override
    public Result getInfo(String token) {
        if(!JwtUtil.validateToken(token)){
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long userId = JwtUtil.getUserIdFromToken(token);
        return Result.okResult(userMapper.selectById(userId));
    }
}
