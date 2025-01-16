package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

import java.io.Serializable;

/**
 * @author dhx
 * @date 2025/1/16 21:58
 */
@TableName("therapy")
public class Therapy implements Serializable {
    @TableId
    private Long id;
    private Long symptomId;
    private String description;
    private DateTime createTime;

    public Therapy() {
    }

    public Therapy(Long symptomId, String description, DateTime createTime) {
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

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }
}
