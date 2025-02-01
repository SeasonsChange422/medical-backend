package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author dhx
 * @date 2025/1/16 21:46
 */
@TableName("symptom")
public class Symptom implements Serializable {
    @TableId
    private Long id;
    private Long userId;
    private boolean tiredness;
    private boolean dryCough;
    private boolean difficultyInBreathing;
    private boolean soreThroat;
    private boolean noSymptom;
    private boolean pains;
    private boolean nasalCongestion;
    private boolean runnyNose;
    private boolean noExperiencing;
    private boolean age0_9;
    private boolean age10_19;
    private boolean age20_24;
    private boolean age25_59;
    private boolean age60;
    private boolean severityMild;
    private boolean severityModerate;
    private boolean severityNone;
    private Date createTime;

    public Symptom() {
    }

    public Symptom( Long userId, boolean tiredness, boolean dryCough, boolean difficultyInBreathing, boolean soreThroat, boolean noSymptom, boolean pains, boolean nasalCongestion, boolean runnyNose, boolean noExperiencing, boolean age0_9, boolean age10_19, boolean age20_24, boolean age25_59, boolean age60, boolean severityMild, boolean severityModerate, boolean severityNone, Date createTime) {
        this.userId = userId;
        this.tiredness = tiredness;
        this.dryCough = dryCough;
        this.difficultyInBreathing = difficultyInBreathing;
        this.soreThroat = soreThroat;
        this.noSymptom = noSymptom;
        this.pains = pains;
        this.nasalCongestion = nasalCongestion;
        this.runnyNose = runnyNose;
        this.noExperiencing = noExperiencing;
        this.age0_9 = age0_9;
        this.age10_19 = age10_19;
        this.age20_24 = age20_24;
        this.age25_59 = age25_59;
        this.age60 = age60;
        this.severityMild = severityMild;
        this.severityModerate = severityModerate;
        this.severityNone = severityNone;
        this.createTime = createTime;
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

    public boolean isTiredness() {
        return tiredness;
    }

    public void setTiredness(boolean tiredness) {
        this.tiredness = tiredness;
    }

    public boolean isDryCough() {
        return dryCough;
    }

    public void setDryCough(boolean dryCough) {
        this.dryCough = dryCough;
    }

    public boolean isDifficultyInBreathing() {
        return difficultyInBreathing;
    }

    public void setDifficultyInBreathing(boolean difficultyInBreathing) {
        this.difficultyInBreathing = difficultyInBreathing;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isNoSymptom() {
        return noSymptom;
    }

    public void setNoSymptom(boolean noSymptom) {
        this.noSymptom = noSymptom;
    }

    public boolean isPains() {
        return pains;
    }

    public void setPains(boolean pains) {
        this.pains = pains;
    }

    public boolean isNasalCongestion() {
        return nasalCongestion;
    }

    public void setNasalCongestion(boolean nasalCongestion) {
        this.nasalCongestion = nasalCongestion;
    }

    public boolean isRunnyNose() {
        return runnyNose;
    }

    public void setRunnyNose(boolean runnyNose) {
        this.runnyNose = runnyNose;
    }

    public boolean isNoExperiencing() {
        return noExperiencing;
    }

    public void setNoExperiencing(boolean noExperiencing) {
        this.noExperiencing = noExperiencing;
    }

    public boolean isAge0_9() {
        return age0_9;
    }

    public void setAge0_9(boolean age0_9) {
        this.age0_9 = age0_9;
    }

    public boolean isAge10_19() {
        return age10_19;
    }

    public void setAge10_19(boolean age10_19) {
        this.age10_19 = age10_19;
    }

    public boolean isAge20_24() {
        return age20_24;
    }

    public void setAge20_24(boolean age20_24) {
        this.age20_24 = age20_24;
    }

    public boolean isAge25_59() {
        return age25_59;
    }

    public void setAge25_59(boolean age25_59) {
        this.age25_59 = age25_59;
    }

    public boolean isAge60() {
        return age60;
    }

    public void setAge60(boolean age60) {
        this.age60 = age60;
    }

    public boolean isSeverityMild() {
        return severityMild;
    }

    public void setSeverityMild(boolean severityMild) {
        this.severityMild = severityMild;
    }

    public boolean isSeverityModerate() {
        return severityModerate;
    }

    public void setSeverityModerate(boolean severityModerate) {
        this.severityModerate = severityModerate;
    }

    public boolean isSeverityNone() {
        return severityNone;
    }

    public void setSeverityNone(boolean severityNone) {
        this.severityNone = severityNone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
