package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author dhx
 * @date 2025/1/16 21:38
 */
@TableName("user")
public class User implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;
    private String username;
    private String password;
    private int gender;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date birthday;
    private String phone;
    @TableField("isAdmin")
    private boolean isAdmin;

    public User() {
    }

    public User(Long id, String username, String password, int gender, String name, Date birthday, String phone, boolean isAdmin) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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
