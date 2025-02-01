package com.zzq.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.Therapy;
import com.zzq.mapper.TherapyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @author dhx
 * @date 2025/2/1 13:53
 */
@Service
public class TherapyServiceImpl implements TherapyService{
    @Autowired
    private TherapyMapper therapyMapper;
    @Override
    public Result newTherapy(Therapy therapy) {
        therapy.setCreateTime(new Date(System.currentTimeMillis()));
        if(therapyMapper.insert(therapy)==1){
            return Result.okResult(200,"上传成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getTherapyById(Long therapyId) {
        Therapy therapy = therapyMapper.selectById(therapyId);
        if(therapy!=null){
            return Result.okResult(therapy);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getTherapyBySymptomId(Long symptomId) {
        Therapy therapy = therapyMapper.selectOne(new QueryWrapper<Therapy>().eq("symptom_id",symptomId));
        if(therapy!=null){
            return Result.okResult(therapy);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
