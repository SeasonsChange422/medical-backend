package com.zzq.controller;

import com.zzq.common.Result;
import com.zzq.entity.Diagnosis;
import com.zzq.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author dhx
 * @date 2025/2/1 14:17
 */
@RestController
public class DiagnosisController {
    @Autowired
    private DiagnosisService diagnosisService;

    @PostMapping("/api/diagnosis/newDiagnosis")
    public Result newDiagnosis(@RequestBody Diagnosis diagnosis){
        return diagnosisService.newDiagnosis(diagnosis);
    }

    @GetMapping("/api/diagnosis/getDiagnosisById")
    public Result getDiagnosisById(@RequestParam Long diagnosisId){
        return diagnosisService.getDiagnosisById(diagnosisId);
    }

    @GetMapping("/api/diagnosis/getDiagnosisInfoBySymptomId")
    public Result getDiagnosisInfoBySymptomId(@RequestParam Long symptomId){
        return diagnosisService.getDiagnosisInfoBySymptomId(symptomId);
    }
}
