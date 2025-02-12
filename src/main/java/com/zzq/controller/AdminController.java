package com.zzq.controller;

import com.zzq.common.Result;
import com.zzq.entity.Diagnosis;
import com.zzq.entity.Therapy;
import com.zzq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dhx
 * @date 2025/2/10 15:14
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/api/admin/getUserList")
    public Result getUserList(@RequestHeader("token") String token){
        return adminService.getUserList(token);
    }

    @PostMapping("/api/admin/setAdmin")
    public Result setAdmin(@RequestHeader("token") String token, @RequestParam Long userId){
        return adminService.setAdmin(token,userId);
    }

    @PostMapping("/api/admin/getSymptomListByUserId")
    public Result getSymptomListByUserId(@RequestHeader("token")String token,@RequestParam Long userId){
        return adminService.getSymptomListByUserId(token,userId);
    }

    @GetMapping("/api/admin/getUserInfoById")
    public Result getUserInfoById(@RequestHeader("token")String token,@RequestParam Long userId){
        return adminService.getUserInfoById(token,userId);
    }

    @GetMapping("/api/admin/getSymptomListWithoutDiagnosis")
    public Result getSymptomListWithoutDiagnosis(@RequestHeader("token")String token){
        return adminService.getSymptomListWithoutDiagnosis(token);
    }

    @PostMapping("/api/admin/addDiagnosis")
    public Result addDiagnosis(@RequestHeader("token")String token, @RequestBody Diagnosis diagnosis){
        return adminService.addDiagnosis(token,diagnosis);
    }

    @GetMapping("/api/admin/getDiagnosisBySymptomId")
    public Result getDiagnosisBySymptomId(@RequestHeader("token")String token,@RequestParam Long symptomId){
        return adminService.getDiagnosisBySymptomId(token,symptomId);
    }

    @GetMapping("/api/admin/getFeedbackList")
    public Result getFeedbackList(@RequestHeader("token")String token){
        return adminService.getFeedbackList(token);
    }

    @GetMapping("/api/admin/getTherapyByUserId")
    public Result getTherapyByUserId(@RequestHeader("token")String token,@RequestParam Long userId){
        return adminService.getTherapyByUserId(token,userId);
    }

    @PostMapping("/api/admin/addTherapy")
    public Result addTherapy(@RequestHeader("token")String token,@RequestBody Therapy therapy){
        return adminService.addTherapy(token,therapy);
    }

    @PostMapping("/api/admin/editTherapy")
    public Result editTherapy(@RequestHeader("token")String token,@RequestBody Therapy therapy){
        return adminService.editTherapy(token,therapy);
    }
}
