package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author dhx
 * @date 2025/1/16 22:01
 */
@TableName("feedback")
public class Feedback implements Serializable {
    @TableId
    private Long id;
    private Long diagnosisId;
    private Long userId;
    private String feedback;
    private Integer score;
    private Date createTime;

    public Feedback() {
    }

    public Feedback(Long diagnosisId,Long userId, String feedback, Integer score, Date createTime) {
        this.diagnosisId = diagnosisId;
        this.userId = userId;
        this.feedback = feedback;
        this.score = score;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
