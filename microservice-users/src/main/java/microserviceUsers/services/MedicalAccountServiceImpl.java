package microserviceUsers.services;

import microserviceUsers.interfaces.MedicalAccountService;
import microserviceUsers.models.MedicalAccount;
import microserviceUsers.repositories.MedicalAccountRepository;
import org.springframework.stereotype.Service;

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
    public MedicalAccount getMedicalAccountWhitEmail(String email) {
        return medicalAccountRepository.findByEmail(email);
    }

}
