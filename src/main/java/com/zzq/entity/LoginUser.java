package com.zzq.entity;

/**
 * @author dhx
 * @date 2025/1/16 22:14
 */
public class LoginUser {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginUser() {
    }

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
