package com.mediscreen.users.controllers;


import com.mediscreen.users.interfaces.PatientService;
import com.mediscreen.users.models.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


/**
 * The type Patients controller.
 */
@RestController
public class PatientsController {

    private final Logger logger = LoggerFactory.getLogger(PatientsController.class);
    private final PatientService patientService;

    /**
     * Instantiates a new Patients controller.
     *
     * @param patientService the patient service
     */
    public PatientsController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Patients list collection.
     *
     * @return the collection
     */
    @GetMapping("/patients")
    public Collection<Patient> patientsList(){
        return patientService.patientsList();
    }

    /**
     * Add patient patient.
     *
     * @param patient the patient
     * @return the patient
     */
    @PostMapping("/patient/add")
    public Patient addPatient(@Valid Patient patient){
        return patientService.addPatient(patient);
    }

    /**
     * Update patient patient.
     *
     * @param id      the id
     * @param patient the patient
     * @return the patient
     */
    @PatchMapping("/patient/update/{id}")
    public Patient updatePatient(@PathVariable int id, @Valid Patient patient){
        return patientService.updatePatient(id, patient);
    }

    /**
     * Get patient patient.
     *
     * @param id the id
     * @return the patient
     */
    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable int id){
        return patientService.getPatient(id);
    }

    /**
     * Delete patient.
     *
     * @param id the id
     */
    @GetMapping("/patient/delete/{id}")
    public void deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
    }
}
