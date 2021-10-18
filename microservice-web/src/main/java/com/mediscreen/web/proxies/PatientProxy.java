package com.mediscreen.web.proxies;

import com.mediscreen.web.config.FeignConfig;
import com.mediscreen.web.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "patient-proxy-users-api", url = "${usersAPI.service.url}", configuration = FeignConfig.class)
public interface PatientProxy {

    @GetMapping("/patients")
    List<Patient> patientsList();

    @PostMapping("/patient/add")
    void addPatient(@RequestParam String sex,
                    @RequestParam String address,
                    @RequestParam String lastName,
                    @RequestParam String firstName,
                    @RequestParam String phone,
                    @RequestParam String dob);

    @PatchMapping("/patient/update/{id}")
    Patient updatePatient(@PathVariable int id,
                          @RequestParam String sex,
                          @RequestParam String address,
                          @RequestParam String lastName,
                          @RequestParam String firstName,
                          @RequestParam String phone,
                          @RequestParam String dob);

    @GetMapping("/patient/delete/{id}")
    void deletePatient(@PathVariable int id);

    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable int id);

}
