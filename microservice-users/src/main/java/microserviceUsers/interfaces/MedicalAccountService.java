package microserviceUsers.interfaces;

import microserviceUsers.models.MedicalAccount;

public interface MedicalAccountService {
    MedicalAccount addMedicalAccount(MedicalAccount medicalAccount);

    MedicalAccount updateMedicalAccount(int id, MedicalAccount medicalAccountUpdate);

    void deleteMedicalAccount(int id);

    MedicalAccount getMedicalAccountWhitEmail(String email);
}
