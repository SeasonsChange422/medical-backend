package com.zzq.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.*;
import com.zzq.mapper.*;
import com.zzq.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * @author dhx
 * @date 2025/2/10 15:15
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SymptomMapper symptomMapper;
    @Autowired
    private DiagnosisMapper diagnosisMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private TherapyMapper therapyMapper;
    @Override
    public Result getUserList(String token) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){ // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        List<User> list = userMapper.selectAll();
        return Result.okResult(list);
    }

    @Override
    public Result getUserInfoById(String token, Long userId) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){ // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        User user1 = userMapper.selectById(userId);
        if(user1!=null){
            return Result.okResult(user1);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getSymptomListByUserId(String token, Long userId) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        List<Symptom> list = symptomMapper.selectList(new QueryWrapper<Symptom>().eq("user_id",userId));
        return Result.okResult(list);
    }

    @Override
    public Result getSymptomListWithoutDiagnosis(String token) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        List<Symptom> list = symptomMapper.getSymptomWithoutDiagnosis();
        JSONArray jsonArray = new JSONArray();
        for (Symptom symptom : list) {
            User user1 = userMapper.selectById(symptom.getUserId());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("user", user1);
            jsonObject.put("symptom", symptom);
            jsonArray.add(jsonObject);
        }
        return Result.okResult(jsonArray);
//        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getDiagnosisBySymptomId(String token, Long symptomId) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        // 获取诊断信息
        Diagnosis diagnosis = diagnosisMapper.selectOne(new QueryWrapper<Diagnosis>().eq("symptom_id",symptomId));
        if(diagnosis!=null){ // 如果不为空
            return Result.okResult(diagnosis);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result getFeedbackList(String token) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        List<Feedback> list = feedbackMapper.selectAll(); // 获取全部反馈
        return Result.okResult(list);
    }

    @Override
    public Result getTherapyByUserId(String token, Long userId) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        // 获取某个用户的个性化推荐
        Therapy therapy = therapyMapper.selectOne(new QueryWrapper<Therapy>().eq("user_id",userId));
        if(therapy != null){
            return Result.okResult(therapy);
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result addDiagnosis(String token, Diagnosis diagnosis) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        diagnosis.setCreateTime(new Date(System.currentTimeMillis()));
        if(diagnosisMapper.insert(diagnosis)==1){ // 成功插入数据库
            return Result.okResult(200,"上传成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result addTherapy(String token, Therapy therapy) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        therapy.setUpdateTime(new Date(System.currentTimeMillis()));

        if(therapyMapper.insert(therapy)==1){
            return Result.okResult(200,"上传成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result setAdmin(String token, Long userId) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User admin = userMapper.selectById(uId);
        if(!admin.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        User user = userMapper.selectById(userId);
        user.setAdmin(!user.isAdmin());
        if(userMapper.updateById(user)==1){
            return Result.okResult(200,"操作成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

    @Override
    public Result editTherapy(String token, Therapy therapy) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long uId = JwtUtil.getUserIdFromToken(token);
        User user = userMapper.selectById(uId);
        if(!user.isAdmin()){  // 不是管理员
            return Result.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        }
        therapy.setUpdateTime(new Date(System.currentTimeMillis()));
        if(therapyMapper.updateById(therapy)==1){ //更新成功
            return Result.okResult(200,"编辑成功");
        }
        return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }
}
