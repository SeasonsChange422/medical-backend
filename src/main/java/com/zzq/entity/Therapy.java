package com.zzq.entity;

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
 * @date 2025/1/16 21:58
 */
@TableName("therapy")
public class Therapy implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private String therapy;
    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT+8")
    private Date updateTime;

    public Therapy() {
    }

    public Therapy(Long userId, String therapy, Date updateTime) {
        this.userId = userId;
        this.therapy = therapy;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
