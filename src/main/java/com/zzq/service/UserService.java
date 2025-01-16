package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.entity.LoginUser;
import com.zzq.entity.User;

/**
 * @author dhx
 * @date 2025/1/16 22:12
 */
public interface UserService {
    public Result login(LoginUser loginUser);
    public Result register(LoginUser loginUser);
    public Result updateInfo(User user);
    public Result logout(String token);
    public Result getInfo(String token);
}
