package com.mediscreen.users.controllers;


import com.mediscreen.users.interfaces.PatientService;
import com.mediscreen.users.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
public class PatientsController {

    private final Logger logger = LoggerFactory.getLogger(PatientsController.class);
    private final PatientService patientService;

    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public Collection<Patient> patientsList(){
        return patientService.patientsList();
    }

    @PostMapping("/patient/add")
    public Patient addPatient(@Valid Patient patient){
        return patientService.addPatient(patient);
    }

    @PatchMapping("/patient/update/{id}")
    public Patient updatePatient(@PathVariable int id, @Valid Patient patient){
        return patientService.updatePatient(id, patient);
    }

    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable int id){
        return patientService.getPatient(id);
    }

    @GetMapping("/patient/delete/{id}")
    public void deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
    }
}
