package com.zzq.controller;

import com.zzq.common.Result;
import com.zzq.entity.Feedback;
import com.zzq.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author dhx
 * @date 2025/2/1 14:17
 */
@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/api/feedback/newFeedback")
    public Result newFeedback(@RequestHeader("token")String token, @RequestBody Feedback feedback){
        return feedbackService.newFeedback(token,feedback);
    }

    @GetMapping("/api/feedback/getFeedbackById")
    public Result getFeedbackById(@RequestParam Long feedbackId){
        return feedbackService.getFeedbackById(feedbackId);
    }

    @GetMapping("/api/feedback/getFeedbackByUserId")
    public Result getFeedbackByUserId(@RequestHeader("token") String token){
        return feedbackService.getFeedbackByUserId(token);
    }
}
