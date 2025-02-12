package com.zzq.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzq.common.Result;
import com.zzq.common.enums.AppHttpCodeEnum;
import com.zzq.entity.Symptom;
import com.zzq.entity.User;
import com.zzq.mapper.SymptomMapper;
import com.zzq.mapper.UserMapper;
import com.zzq.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;


/**
 * @author dhx
 * @date 2025/2/1 13:13
 */
@Service
public class SymptomServiceImpl implements SymptomService{
    @Autowired
    private SymptomMapper symptomMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result newSymptom(String token,Symptom symptom) {
        if(!JwtUtil.validateToken(token)){ //非法token（错误或者过期）
            return Result.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        }
        Long userId = JwtUtil.getUserIdFromToken(token);
        symptom.setUserId(userId);
        symptom.setCreateTime(new Date(System.currentTimeMillis())); //System.currentTimeMillis()获取系统当前时间
        JSONObject jsonObject = getResult(symptom);
        if(jsonObject==null){
            return Result.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
        }
        if((int)jsonObject.get("prediction")==0){
            symptom.setSeverityNone(true);
        } else {
            symptom.setSeverityMild(true);
        }
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

    public JSONObject getResult(Symptom symptom){
        try {
            User user = userMapper.selectById(symptom.getUserId());
            Date birthday = user.getBirthday();
            LocalDate birthDate = birthday.toLocalDate();
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();
            int age_group = 0;
            if(age>=0&&age<=24)age_group=1;
            else if(age>=25&&age<=59)age_group=2;
            else if(age>=60)age_group=3;
            // 定义接口URL
            String url = "http://localhost:8090/predict?" +
                    "t=" + URLEncoder.encode(symptom.isTiredness() ?"1":"0", "UTF-8") +
                    "&dc=" + URLEncoder.encode(symptom.isDryCough() ?"1":"0","UTF-8") +
                    "&dib=" + URLEncoder.encode(symptom.isDifficultyInBreathing() ?"1":"0","UTF-8") +
                    "&st=" + URLEncoder.encode(symptom.isSoreThroat() ?"1":"0","UTF-8") +
                    "&p=" + URLEncoder.encode(symptom.isPains() ?"1":"0","UTF-8") +
                    "&nc=" + URLEncoder.encode(symptom.isNasalCongestion() ?"1":"0","UTF-8") +
                    "&rn=" + URLEncoder.encode(symptom.isRunnyNose() ?"1":"0","UTF-8") +
                    "&a=" + age_group;

            URL apiUrl = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // 设置请求方法为GET
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept-Encoding", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            // 发送请求并获取响应状态码
            int responseCode = connection.getResponseCode();

            // 根据响应状态码判断请求是否成功
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 读取响应内容
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                connection.disconnect();

                return JSONObject.parseObject(response.toString());
            } else {
                // 请求失败
                connection.disconnect();
                return null;
            }

            // 关闭连接
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
