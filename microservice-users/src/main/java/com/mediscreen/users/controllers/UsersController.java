package com.mediscreen.users.controllers;


import com.mediscreen.users.interfaces.UsersService;
import com.mediscreen.users.models.Patient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/patients")
    public Collection<Patient> patientsList(){
        return usersService.patientsList();
    }

    @PostMapping("/patient/add")
    public Patient addPatient(Patient patient){
        return usersService.addPatient(patient);
    }

    @PatchMapping("/patient/update/{id}")
    public Patient updatePatient(@PathVariable int id, @Valid Patient patient){
        return usersService.updatePatient(id, patient);
    }

    @DeleteMapping("/patient/delete/{id}")
    public void deletePatient(@PathVariable int id){
        usersService.deletePatient(id);
    }
}
