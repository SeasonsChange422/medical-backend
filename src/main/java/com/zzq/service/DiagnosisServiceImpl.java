package com.zzq.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.Diagnosis;
import com.zzq.mapper.DiagnosisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @author dhx
 * @date 2025/2/1 13:37
 */
@Service
public class DiagnosisServiceImpl implements DiagnosisService{
    @Autowired
    private DiagnosisMapper diagnosisMapper;
    @Override
    public Result newDiagnosis(Diagnosis diagnosis) {
        diagnosis.setCreateTime(new Date(System.currentTimeMillis()));
        if(diagnosisMapper.insert(diagnosis)==1){
            return Result.okResult(200,"上传成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getDiagnosisById(Long diagnosisId) {
        Diagnosis diagnosis = diagnosisMapper.selectById(diagnosisId);
        if(diagnosis!=null){
            return Result.okResult(diagnosis);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getDiagnosisInfoBySymptomId(Long symptomId) {
        Diagnosis diagnosis = diagnosisMapper.selectOne(new QueryWrapper<Diagnosis>().eq("symptom_id",symptomId));
        if(diagnosis!=null){
            return Result.okResult(diagnosis);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
