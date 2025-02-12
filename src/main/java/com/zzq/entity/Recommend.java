package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author dhx
 * @date 2025/2/12 21:19
 */
@TableName("recommend")
public class Recommend {
    @TableId
    private int id;
    private String symptom;
    private String therapy;

    public Recommend() {
    }

    public Recommend(int id, String symptom, String therapy) {
        this.id = id;
        this.symptom = symptom;
        this.therapy = therapy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }
}
