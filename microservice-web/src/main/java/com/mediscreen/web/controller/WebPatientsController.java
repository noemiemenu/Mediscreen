package com.mediscreen.web.controller;

import com.mediscreen.web.model.Patient;
import com.mediscreen.web.model.PatientWithReport;
import com.mediscreen.web.proxies.PatientProxy;
import com.mediscreen.web.proxies.ReportProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Web patients controller.
 */
@Controller
public class WebPatientsController {

    private final PatientProxy patientProxy;
    private final ReportProxy reportProxy;

    private final Logger logger = LoggerFactory.getLogger(WebPatientsController.class);

    /**
     * Instantiates a new Web patients controller.
     *
     * @param patientProxy the patient proxy
     * @param reportProxy  the report proxy
     */
    public WebPatientsController(PatientProxy patientProxy, ReportProxy reportProxy) {
        this.patientProxy = patientProxy;
        this.reportProxy = reportProxy;
    }


    /**
     * Show home string.
     *
     * @param model the model
     * @return the string
     */
    @GetMapping("/patient/home")
    public String showHome(Model model) {
        List<Patient> patients = patientProxy.patientsList();
        List<PatientWithReport> patientWithReportList = new ArrayList<>();
        for (Patient patient : patients) {
            String report = reportProxy.getReport(patient.getId());
            int numberOfTriggerTerms = reportProxy.getNumberOfTriggerTerms(patient.getId());
            int age = LocalDate.now().getYear() - patient.getDob().getYear();
            patientWithReportList.add(new PatientWithReport(report, patient, age, numberOfTriggerTerms ));
        }
        model.addAttribute("patients", patientWithReportList);


        return "patient/home";
    }

    /**
     * Show add patient form string.
     *
     * @return the string
     */
    @GetMapping("/patient/add")
    public String showAddPatientForm() {
        return "patient/add";
    }

    /**
     * Validate string.
     *
     * @param patient the patient
     * @return the string
     */
    @PostMapping("/patient/add")
    public String validate(@Valid Patient patient) {
        patientProxy.addPatient(patient.getSex(),
                patient.getAddress(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getPhone(),
                patient.getDob().format(DateTimeFormatter.ISO_DATE));
        return "redirect:/patient/home";
    }

    /**
     * Show update form string.
     *
     * @param id    the id
     * @param model the model
     * @return the string
     */
    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientProxy.getPatient(id);
        model.addAttribute("patient", patient);
        logger.info("Patient id from microservice-users: " + patient.getId());
        return "patient/update";
    }

    /**
     * Update patient string.
     *
     * @param id      the id
     * @param patient the patient
     * @return the string
     */
    @PostMapping("/patient/update/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid Patient patient) {
        logger.info("patient id: " + patient.getId());
        logger.info("patient name: " + patient.getFirstName() + " " + patient.getLastName());

        patientProxy.updatePatient(id,
                patient.getSex(),
                patient.getAddress(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getPhone(),
                patient.getDob().format(DateTimeFormatter.ISO_DATE)
        );
        return "redirect:/patient/home";
    }

    /**
     * Delete patient string.
     *
     * @param id the id
     * @return the string
     */
    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id) {
        patientProxy.deletePatient(id);
        return "redirect:/patient/home";
    }

}
