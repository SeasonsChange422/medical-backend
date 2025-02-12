package com.zzq.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.Feedback;
import com.zzq.mapper.FeedbackMapper;
import com.zzq.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * @author dhx
 * @date 2025/2/1 14:04
 */
@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Override
    public Result newFeedback(String token, Feedback feedback) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long userId = JwtUtil.getUserIdFromToken(token);
        feedback.setUserId(userId);
        feedback.setCreateTime(new Date(System.currentTimeMillis()));
        if(feedbackMapper.insert(feedback)==1){
            return Result.okResult(200,"上传成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getFeedbackById(Long feedbackId) {
        Feedback feedback = feedbackMapper.selectById(feedbackId);
        if(feedback!=null){
            return Result.okResult(feedback);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getFeedbackByUserId(String token) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long userId = JwtUtil.getUserIdFromToken(token);
        Feedback feedback = feedbackMapper.selectOne(new QueryWrapper<Feedback>().eq("user_id",userId));
        if(feedback!=null){
            return Result.okResult(feedback);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getFeedbackByDiagnosisId(Long diagnosisId) {
        Feedback feedback = feedbackMapper.selectOne(new QueryWrapper<Feedback>().eq("diagnosis_id",diagnosisId));
        if(feedback!=null){
            return Result.okResult(feedback);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
