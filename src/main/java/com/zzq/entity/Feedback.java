package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

import java.io.Serializable;

/**
 * @author dhx
 * @date 2025/1/16 22:01
 */
@TableName("feedback")
public class Feedback implements Serializable {
    @TableId
    private Long id;
    private Long diagnosisId;
    private String feedback;
    private Integer score;
    private DateTime createTime;

    public Feedback() {
    }

    public Feedback(Long diagnosisId, String feedback, Integer score, DateTime createTime) {
        this.diagnosisId = diagnosisId;
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

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }
}
