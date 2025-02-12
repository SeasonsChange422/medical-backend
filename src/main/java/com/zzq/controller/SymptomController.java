package com.zzq.controller;

import com.zzq.common.Result;
import com.zzq.entity.Symptom;
import com.zzq.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author dhx
 * @date 2025/2/1 14:16
 */
@RestController
public class SymptomController {
    @Autowired
    private SymptomService symptomService;

    @PostMapping("/api/symptom/newSymptom")
    public Result newSymptom(@RequestHeader("token")String token, @RequestBody Symptom symptom){
        return symptomService.newSymptom(token,symptom);
    }

    @GetMapping("/api/symptom/getSymptomById")
    public Result getSymptomById(@RequestParam Long symptomId){
        return symptomService.getSymptomById(symptomId);
    }

    @GetMapping("/api/symptom/getSymptomList")
    public Result getSymptomList(@RequestHeader("token")String token){
        return symptomService.getSymptomList(token);
    }
}
