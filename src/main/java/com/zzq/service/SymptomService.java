package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.entity.Symptom;

/**
 * @author dhx
 * @date 2025/2/1 13:13
 */
public interface SymptomService {
    // 新建症状（病历）
    public Result newSymptom(String token,Symptom symptom);
    // 获取某次症状（病历）信息
    public Result getSymptomById(Long symptomId);
    // 获取当前用户所有的历史症状（病历）
    public Result getSymptomList(String token);
}
