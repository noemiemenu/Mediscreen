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
    private final PatientService usersService;

    public PatientsController(PatientService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/patients")
    public Collection<Patient> patientsList(){
        return usersService.patientsList();
    }

    @PostMapping("/patient/add")
    public Patient addPatient(@Valid Patient patient){
        return usersService.addPatient(patient);
    }

    @PatchMapping("/patient/update/{id}")
    public Patient updatePatient(@PathVariable int id, @Valid Patient patient){
        return usersService.updatePatient(id, patient);
    }

    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable int id){
        return usersService.getPatient(id);
    }

    @GetMapping("/patient/delete/{id}")
    public void deletePatient(@PathVariable int id){
        usersService.deletePatient(id);
    }
}
