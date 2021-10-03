package com.mediscreen.users.interfaces;


import com.mediscreen.users.models.MedicalAccount;
import com.mediscreen.users.models.Patient;

import java.util.Collection;

public interface MedicalAccountService {

    MedicalAccount addMedicalAccount(MedicalAccount medicalAccount);

    MedicalAccount updateMedicalAccount(int id, MedicalAccount medicalAccount);

    void deleteMedicalAccount(int id);

    MedicalAccount findMedicalAccountWhitEmail(String email);

    Collection<MedicalAccount> medicalAccountList();
}
