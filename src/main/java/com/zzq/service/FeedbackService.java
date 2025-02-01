package com.zzq.service;

import com.zzq.common.Result;
import com.zzq.entity.Feedback;

/**
 * @author dhx
 * @date 2025/2/1 14:04
 */
public interface FeedbackService {
    // 新建反馈
    public Result newFeedback(String token,Feedback feedback);
    // 获取某次反馈信息
    public Result getFeedbackById(Long feedbackId);
    // 获取当前用户所有反馈
    public Result getFeedbackByUserId(String token);
}
