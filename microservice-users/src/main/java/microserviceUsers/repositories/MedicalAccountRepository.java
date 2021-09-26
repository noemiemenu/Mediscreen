package microserviceUsers.repositories;

import microserviceUsers.models.MedicalAccount;
import org.springframework.data.repository.CrudRepository;

public interface MedicalAccountRepository extends CrudRepository<MedicalAccount, Integer> {

    MedicalAccount findById(int id);

    MedicalAccount findByEmail(String email);
}
