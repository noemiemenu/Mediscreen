package com.mediscreen.users.controllers;

import com.mediscreen.users.interfaces.MedicalAccountService;
import com.mediscreen.users.models.MedicalAccount;
import com.mediscreen.users.models.Patient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
public class MedicalAccountController {
    private final MedicalAccountService medicalAccountService;

    public MedicalAccountController(MedicalAccountService medicalAccountService) {
        this.medicalAccountService = medicalAccountService;
    }

    @PostMapping("/medicalAccount/add")
    public MedicalAccount addPatient(MedicalAccount medicalAccount){
        return medicalAccountService.addMedicalAccount(medicalAccount);
    }

    @PatchMapping("/medicalAccount/update/{id}")
    public MedicalAccount updatePatient(@PathVariable int id, @Valid MedicalAccount medicalAccount){
        return medicalAccountService.updateMedicalAccount(id, medicalAccount);
    }

    @DeleteMapping("/medicalAccount/delete/{id}")
    public void deletePatient(@PathVariable int id){
        medicalAccountService.deleteMedicalAccount(id);
    }

    @GetMapping("/medicalAccount/{email}")
    public MedicalAccount findMedicalAccountWhitEmail(@PathVariable String email){
        return medicalAccountService.findMedicalAccountWhitEmail(email);
    }

    @GetMapping("/medicalAccounts")
    public Collection<MedicalAccount> medicalAccountList(){
        return medicalAccountService.medicalAccountList();
    }


}
