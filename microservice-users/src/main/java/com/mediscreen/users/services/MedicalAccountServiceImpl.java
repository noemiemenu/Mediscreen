package com.mediscreen.users.services;

import com.mediscreen.users.interfaces.MedicalAccountService;
import com.mediscreen.users.models.MedicalAccount;
import com.mediscreen.users.models.Patient;
import com.mediscreen.users.repositories.MedicalAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MedicalAccountServiceImpl implements MedicalAccountService {

    private final MedicalAccountRepository medicalAccountRepository;

    public MedicalAccountServiceImpl(MedicalAccountRepository medicalAccountRepository) {
        this.medicalAccountRepository = medicalAccountRepository;
    }

    @Override
    public MedicalAccount addMedicalAccount(MedicalAccount medicalAccount){
        return medicalAccountRepository.save(medicalAccount);
    }

    @Override
    public MedicalAccount updateMedicalAccount(int id, MedicalAccount medicalAccountUpdate) {
        MedicalAccount medicalAccount = medicalAccountRepository.findById(id);
        medicalAccount.setFirstName(medicalAccountUpdate.getFirstName());
        medicalAccount.setLastName(medicalAccountUpdate.getLastName());
        medicalAccount.setAddress(medicalAccountUpdate.getAddress());
        medicalAccount.setEmail(medicalAccountUpdate.getEmail());
        medicalAccount.setPhone(medicalAccountUpdate.getPhone());
        medicalAccount.setPassword(medicalAccountUpdate.getPassword());
        medicalAccountRepository.save(medicalAccount);
        return medicalAccount;
    }


    @Override
    public void deleteMedicalAccount(int id){
        medicalAccountRepository.deleteById(id);
    }

    @Override
    public MedicalAccount findMedicalAccountWhitEmail(String email) {
        return medicalAccountRepository.findByEmail(email);
    }

    @Override
    public Collection<MedicalAccount> medicalAccountList() {
        return StreamSupport
                .stream(medicalAccountRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

}
