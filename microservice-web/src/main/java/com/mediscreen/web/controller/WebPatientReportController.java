package com.mediscreen.web.controller;

import com.mediscreen.web.model.PatientInfo;
import com.mediscreen.web.service.WebPatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebPatientReportController {

    private final WebPatientService webPatientService;


    public WebPatientReportController(WebPatientService webPatientService) {
        this.webPatientService = webPatientService;

    }

    @GetMapping("/patientInfo/{id}")
    public PatientInfo getPatientInfo(@PathVariable("id") Integer id){
        return webPatientService.patientInfo(id);
    }


}
