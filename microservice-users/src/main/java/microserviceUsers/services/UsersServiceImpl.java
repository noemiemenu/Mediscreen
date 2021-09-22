package microserviceUsers.services;

import microserviceUsers.interfaces.UsersService;
import microserviceUsers.models.Patient;
import microserviceUsers.repositories.UsersRepository;
import org.springframework.stereotype.Service;


@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Patient addPatient(Patient patient){
        return usersRepository.save(patient);
    }

    @Override
    public Patient updatePatient(int id, Patient patientToUpdate) {
        Patient patient = usersRepository.findById(id);
        patient.setFirstName(patientToUpdate.getFirstName());
        patient.setLastName(patientToUpdate.getLastName());
        patient.setAddress(patientToUpdate.getAddress());
        patient.setBirthdate(patientToUpdate.getBirthdate());
        patient.setEmail(patientToUpdate.getEmail());
        patient.setGender(patientToUpdate.getGender());
        patient.setPhone(patientToUpdate.getPhone());
        usersRepository.save(patient);
        return patient;
    }

    @Override
    public void deletePatient(int id) {
        usersRepository.deleteById(id);
    }


}
