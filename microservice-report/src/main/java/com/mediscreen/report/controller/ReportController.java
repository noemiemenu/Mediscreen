package com.mediscreen.report.controller;

import com.mediscreen.report.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Report controller.
 */
@RestController
public class ReportController {

    private final ReportService reportService;

    /**
     * Instantiates a new Report controller.
     *
     * @param reportService the report service
     */
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    /**
     * Get number of trigger terms int.
     *
     * @param id the id
     * @return the int
     */
    @GetMapping("/numberOfTriggerTermsByPatientId/{id}")
    public int getNumberOfTriggerTerms(@PathVariable int id){
        return reportService.numberOfTriggerTerms(id);
    }

    /**
     * Get report string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/assess/{id}")
    public String getReport(@PathVariable int id){
        return reportService.getTypeOfRisk(id);
    }


}
