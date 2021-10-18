package com.mediscreen.report.controller;

import com.mediscreen.report.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    @GetMapping("/numberOfTriggerTermsByPatientId/{id}")
    public int getNumberOfTriggerTerms(@PathVariable int id){
        return reportService.numberOfTriggerTerms(id);
    }

    @GetMapping("/assess/{id}")
    public String getReport(@PathVariable int id){
        return reportService.getTypeOfRisk(id);
    }


}
