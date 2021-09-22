package microserviceUsers.repositories;

import microserviceUsers.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Patient, Integer> {

    Patient findById(int id);

    void deleteById(int id);
}
