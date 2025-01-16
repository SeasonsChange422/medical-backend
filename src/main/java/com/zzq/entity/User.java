package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

import java.io.Serializable;

/**
 * @author dhx
 * @date 2025/1/16 21:38
 */
@TableName("user")
public class User implements Serializable {
    @TableId
    private Long id;
    private String username;
    private String password;
    private int gender;
    private int name;
    private DateTime birthday;
    private String phone;
    private boolean isAdmin;

    public User() {
    }

    public User(Long id, String username, String password, int gender, int name, DateTime birthday, String phone, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
