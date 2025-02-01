package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.entity.Therapy;

/**
 * @author dhx
 * @date 2025/2/1 13:53
 */
public interface TherapyService {
    // 新建治疗建议
    public Result newTherapy(Therapy therapy);
    // 获取某次治疗建议（通过治疗建议id）
    public Result getTherapyById(Long therapyId);
    // 获取某次病历的治疗建议
    public Result getTherapyBySymptomId(Long symptomId);

}
