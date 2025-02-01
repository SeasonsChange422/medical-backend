package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.entity.Diagnosis;

/**
 * @author dhx
 * @date 2025/2/1 13:37
 */
public interface DiagnosisService {
    // 新建诊断
    public Result newDiagnosis(Diagnosis diagnosis);
    // 获取某次诊断信息
    public Result getDiagnosisById(Long diagnosisId);
    // 获取某次病历的诊断信息
    public Result getDiagnosisInfoBySymptomId(Long symptomId);
}
