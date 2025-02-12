package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.entity.Recommend;
import com.zzq.entity.Symptom;

/**
 * @author dhx
 * @date 2025/2/12 21:24
 */
public interface RecommendService {
    public Result getRecommendList();
    public Result updateRecommend(Recommend recommend);
    public Result getRecommendTherapy(Symptom symptom);
}
