package com.mediscreen.web.controller;

import com.mediscreen.web.model.PatientInfo;
import com.mediscreen.web.service.WebPatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Web patient report controller.
 */
@RestController
public class WebPatientReportController {

    private final WebPatientService webPatientService;


    /**
     * Instantiates a new Web patient report controller.
     *
     * @param webPatientService the web patient service
     */
    public WebPatientReportController(WebPatientService webPatientService) {
        this.webPatientService = webPatientService;

    }

    /**
     * Gets patient info.
     *
     * @param id the id
     * @return the patient info
     */
    @GetMapping("/patientInfo/{id}")
    public PatientInfo getPatientInfo(@PathVariable("id") Integer id){
        return webPatientService.getPatientInfo(id);
    }


}
