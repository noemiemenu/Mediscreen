package com.mediscreen.users.services;

import com.mediscreen.users.interfaces.PatientService;
import com.mediscreen.users.models.Patient;
import com.mediscreen.users.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(int id, Patient patientToUpdate) {
        Patient patient = patientRepository.findById(id);
        patient.setFamily(patientToUpdate.getFamily());
        patient.setGiven(patientToUpdate.getGiven());
        patient.setFirstName(patientToUpdate.getFirstName());
        patient.setLastName(patientToUpdate.getLastName());
        patient.setAddress(patientToUpdate.getAddress());
        patient.setDob(patientToUpdate.getDob());
        patient.setEmail(patientToUpdate.getEmail());
        patient.setSex(patientToUpdate.getSex());
        patient.setPhone(patientToUpdate.getPhone());
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Collection<Patient> patientsList() {
        return StreamSupport
                .stream(patientRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Patient getPatient(int id){
        return patientRepository.findById(id);
    }


}
