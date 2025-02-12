package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.entity.Diagnosis;
import com.zzq.entity.Therapy;

/**
 * @author dhx
 * @date 2025/2/10 15:14
 */
public interface AdminService {
    public Result getUserList(String token);
    public Result getUserInfoById(String token,Long userId);
    public Result getSymptomListByUserId(String token,Long userId);
    public Result getSymptomListWithoutDiagnosis(String token);
    public Result getDiagnosisBySymptomId(String token,Long symptomId);
    public Result getFeedbackList(String token);
    public Result getTherapyByUserId(String token,Long userId);
    public Result addDiagnosis(String token, Diagnosis diagnosis);
    public Result addTherapy(String token, Therapy therapy);
    public Result setAdmin(String token,Long userId);
    public Result editTherapy(String token,Therapy therapy);
}
