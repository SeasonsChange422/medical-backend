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
 * @date 2025/1/16 21:53
 */
@TableName("diagnosis")
public class Diagnosis implements Serializable {
    @JsonSerialize(using = ToStringSerializer.class)
    @TableId
    private Long id;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long symptomId;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    public Diagnosis() {
    }

    public Diagnosis(Long symptomId, String description, Date createTime) {
        this.symptomId = symptomId;
        this.description = description;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSymptomId() {
        return symptomId;
    }

    public void setSymptomId(Long symptomId) {
        this.symptomId = symptomId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
