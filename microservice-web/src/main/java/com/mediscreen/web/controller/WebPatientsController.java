package com.mediscreen.web.controller;

import com.mediscreen.web.model.Patient;
import com.mediscreen.web.proxies.PatientProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller
public class WebPatientsController {

    private final PatientProxy patientProxy;

    private final Logger logger = LoggerFactory.getLogger(WebPatientsController.class);

    public WebPatientsController(PatientProxy patientProxy) {
        this.patientProxy = patientProxy;
    }


    @GetMapping("/patient/home")
    public String showHome(Model model) {
        model.addAttribute("patients", patientProxy.patientsList());
        return "patient/home";
    }

    @GetMapping("/patient/add")
    public String showAddPatientForm() {
        return "patient/add";
    }

    @PostMapping("/patient/add")
    public String validate(@Valid Patient patient) {
        patientProxy.addPatient(patient.getSex(),
                patient.getFamily(),
                patient.getGiven(),
                patient.getAddress(),
                patient.getEmail(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getPhone(),
                patient.getDob().format(DateTimeFormatter.ISO_DATE));
        return "redirect:/patient/home";
    }

    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientProxy.getPatient(id);
        model.addAttribute("patient", patient);
        logger.info("Patient id from microservice-users: " + patient.getId());
        return "patient/update";
    }

    @PostMapping("/patient/update/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid Patient patient) {
        logger.info("patient id: " + patient.getId());
        logger.info("patient name: " + patient.getFirstName() + " " + patient.getLastName());

        patientProxy.updatePatient(id,
                patient.getSex(),
                patient.getFamily(),
                patient.getGiven(),
                patient.getAddress(),
                patient.getEmail(),
                patient.getLastName(),
                patient.getFirstName(),
                patient.getPhone(),
                patient.getDob().format(DateTimeFormatter.ISO_DATE)
        );
        return "redirect:/patient/home";
    }

    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id) {
        patientProxy.deletePatient(id);
        return "redirect:/patient/home";
    }

}
