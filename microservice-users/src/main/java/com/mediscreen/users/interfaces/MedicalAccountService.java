package com.mediscreen.users.interfaces;


import com.mediscreen.users.models.MedicalAccount;

public interface MedicalAccountService {
    MedicalAccount addMedicalAccount(MedicalAccount medicalAccount);

    MedicalAccount updateMedicalAccount(int id, MedicalAccount medicalAccountUpdate);

    void deleteMedicalAccount(int id);

    MedicalAccount getMedicalAccountWhitEmail(String email);
}
