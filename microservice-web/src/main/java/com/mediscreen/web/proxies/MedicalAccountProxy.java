package com.mediscreen.web.proxies;

import com.mediscreen.web.model.MedicalAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "microservice-users")
public interface MedicalAccountProxy {


    @PostMapping("/medicalAccount/add")
    MedicalAccount addPatient(MedicalAccount medicalAccount);

    @PatchMapping("/medicalAccount/update/{id}")
     MedicalAccount updatePatient(@PathVariable int id, MedicalAccount medicalAccount);

    @DeleteMapping("/medicalAccount/delete/{id}")
    void deletePatient(@PathVariable int id);

    @GetMapping("/medicalAccount/{email}")
    MedicalAccount findMedicalAccountWhitEmail(@PathVariable String email);

    @GetMapping("/medicalAccounts")
    Collection<MedicalAccount> medicalAccountList();

}
