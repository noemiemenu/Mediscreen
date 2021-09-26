package microserviceUsers.interfaces;

import microserviceUsers.models.Patient;

import java.util.Collection;

public interface UsersService {

    Patient addPatient(Patient patient);

    Patient updatePatient(int id, Patient patient);

    void deletePatient(int id);

    Collection<Patient> patientsList();
}
