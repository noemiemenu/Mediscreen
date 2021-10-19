package com.mediscreen.web.proxies;

import com.mediscreen.web.config.FeignConfig;
import com.mediscreen.web.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * The interface Patient proxy.
 */
@FeignClient(name = "patient-proxy-users-api", url = "${usersAPI.service.url}", configuration = FeignConfig.class)
public interface PatientProxy {

    /**
     * Patients list list.
     *
     * @return the list
     */
    @GetMapping("/patients")
    List<Patient> patientsList();

    /**
     * Add patient.
     *
     * @param sex       the sex
     * @param address   the address
     * @param lastName  the last name
     * @param firstName the first name
     * @param phone     the phone
     * @param dob       the dob
     */
    @PostMapping("/patient/add")
    void addPatient(@RequestParam String sex,
                    @RequestParam String address,
                    @RequestParam String lastName,
                    @RequestParam String firstName,
                    @RequestParam String phone,
                    @RequestParam String dob);

    /**
     * Update patient patient.
     *
     * @param id        the id
     * @param sex       the sex
     * @param address   the address
     * @param lastName  the last name
     * @param firstName the first name
     * @param phone     the phone
     * @param dob       the dob
     * @return the patient
     */
    @PatchMapping("/patient/update/{id}")
    Patient updatePatient(@PathVariable int id,
                          @RequestParam String sex,
                          @RequestParam String address,
                          @RequestParam String lastName,
                          @RequestParam String firstName,
                          @RequestParam String phone,
                          @RequestParam String dob);

    /**
     * Delete patient.
     *
     * @param id the id
     */
    @GetMapping("/patient/delete/{id}")
    void deletePatient(@PathVariable int id);

    /**
     * Gets patient.
     *
     * @param id the id
     * @return the patient
     */
    @GetMapping("/patient/{id}")
    Patient getPatient(@PathVariable int id);

}
