package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.Recommend;
import com.zzq.entity.Symptom;
import com.zzq.mapper.RecommendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dhx
 * @date 2025/2/12 21:24
 */
@Service
public class RecommendServiceImpl implements RecommendService{
    @Autowired
    private RecommendMapper recommendMapper;
    @Override
    public Result getRecommendList() {
        return Result.okResult(recommendMapper.getAll());
    }

    @Override
    public Result updateRecommend(Recommend recommend) {
        if(recommendMapper.updateById(recommend)==1){
            return Result.okResult(200,"更新成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getRecommendTherapy(Symptom symptom) {
        List<Recommend> list = recommendMapper.getAll();
        List<String> ret = new ArrayList<>();
        if(symptom.isTiredness())ret.add(list.get(0).getTherapy());
        if(symptom.isDryCough())ret.add(list.get(1).getTherapy());
        if(symptom.isDifficultyInBreathing())ret.add(list.get(2).getTherapy());
        if(symptom.isSoreThroat())ret.add(list.get(3).getTherapy());
        if(symptom.isPains())ret.add(list.get(4).getTherapy());
        if(symptom.isNasalCongestion())ret.add(list.get(5).getTherapy());
        if(symptom.isRunnyNose())ret.add(list.get(6).getTherapy());
        return Result.okResult(ret);
    }
}
