package microserviceUsers.interfaces;

import microserviceUsers.models.Patient;

public interface UsersService {

    Patient addPatient(Patient patient);

    Patient updatePatient(int id, Patient patient);

    void deletePatient(int id);
}
