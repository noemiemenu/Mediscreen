package com.mediscreen.web.controller;

import com.mediscreen.web.model.PatientInfo;
import com.mediscreen.web.service.PatientInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientInfoController {

    private final PatientInfoService patientInfoService;

    public PatientInfoController(PatientInfoService patientInfoService) {
        this.patientInfoService = patientInfoService;
    }

    @GetMapping("/patientInfo/{id}")
    public PatientInfo getPatientInfo(@PathVariable("id") Integer id){
        return patientInfoService.patientInfo(id);
    }
}
