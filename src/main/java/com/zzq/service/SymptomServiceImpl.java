package com.zzq.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.Symptom;
import com.zzq.mapper.SymptomMapper;
import com.zzq.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @author dhx
 * @date 2025/2/1 13:13
 */
@Service
public class SymptomServiceImpl implements SymptomService{
    @Autowired
    private SymptomMapper symptomMapper;
    @Override
    public Result newSymptom(String token,Symptom symptom) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long userId = JwtUtil.getUserIdFromToken(token);
        symptom.setUserId(userId);
        symptom.setCreateTime(new Date(System.currentTimeMillis())); //System.currentTimeMillis()获取系统当前时间
        if(symptomMapper.insert(symptom)==1){
            return Result.okResult(200,"上传成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getSymptomById(Long symptomId) {
        Symptom symptom = symptomMapper.selectById(symptomId);
        if(symptom!=null){ //查询的实体不为空
            return Result.okResult(symptom);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getSymptomList(String token) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long userId = JwtUtil.getUserIdFromToken(token);
        List<Symptom> list = symptomMapper.selectList(new QueryWrapper<Symptom>().eq("user_id",userId));
        if(!list.isEmpty()){
            return Result.okResult(list);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
