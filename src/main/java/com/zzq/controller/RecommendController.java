package com.zzq.controller;

import com.zzq.common.Result;
import com.zzq.entity.Recommend;
import com.zzq.entity.Symptom;
import com.zzq.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dhx
 * @date 2025/2/12 21:25
 */
@RestController
public class RecommendController {
    @Autowired
    private RecommendService recommendService;
    @GetMapping("/api/recommend/getRecommendList")
    public Result getRecommendList(){
        return recommendService.getRecommendList();
    }
    @PostMapping("/api/recommend/updateRecommend")
    public Result updateRecommend(@RequestBody Recommend recommend){
        return recommendService.updateRecommend(recommend);
    }
    @PostMapping("/api/recommend/getRecommendTherapy")
    public Result getRecommendTherapy(@RequestBody Symptom symptom){
        return recommendService.getRecommendTherapy(symptom);
    }
}
