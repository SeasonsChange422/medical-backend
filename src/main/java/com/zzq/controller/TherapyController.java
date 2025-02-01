package com.zzq.controller;

import com.zzq.common.Result;
import com.zzq.entity.Therapy;
import com.zzq.service.TherapyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dhx
 * @date 2025/2/1 14:16
 */
@Controller
public class TherapyController {
    @Autowired
    private TherapyService therapyService;

    @PostMapping("/api/therapy/newTherapy")
    public Result newTherapy(@RequestBody Therapy therapy){
        return therapyService.newTherapy(therapy);
    }

    @GetMapping("/api/therapy/getTherapyById")
    public Result getTherapyById(@RequestParam Long therapyId){
        return therapyService.getTherapyById(therapyId);
    }

    @GetMapping("/api/therapy/getTherapyBySymptomId")
    public Result getTherapyBySymptomId(@RequestParam Long symptomId){
        return therapyService.getTherapyBySymptomId(symptomId);
    }
}
