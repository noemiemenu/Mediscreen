package microserviceweb.proxies;

import microserviceweb.model.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@FeignClient(name = "users-API", url = "http://localhost:8383")
public interface MicroserviceUsersProxy {

    @GetMapping("/patients")
    Collection<Patient> patientsList();

    @PostMapping("/patient/add")
    Patient addPatient(Patient patient);

    @PatchMapping("/patient/update/{id}")
    Patient updatePatient(@PathVariable("id") int id, @Valid Patient patient);

    @DeleteMapping("/patient/delete/{id}")
    void deletePatient(@PathVariable("id") int id);
}
