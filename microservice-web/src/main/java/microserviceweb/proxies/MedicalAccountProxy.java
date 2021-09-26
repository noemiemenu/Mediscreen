package microserviceweb.proxies;

import microserviceweb.model.MedicalAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient(name = "medicalAccount-API", url = "http://localhost:8383")
public interface MedicalAccountProxy {

    @PostMapping("/medicalAccount/add")
    MedicalAccount addMedicalAccount(MedicalAccount medicalAccount);

    @PatchMapping("/medicalAccount/update/{id}")
    MedicalAccount updateMedicalAccount(@PathVariable("id") int id, @Valid MedicalAccount medicalAccount);

    @DeleteMapping("/medicalAccount/delete/{id}")
    void deleteMedicalAccount(@PathVariable("id") int id);

    @GetMapping("/medicalAccount/email")
    MedicalAccount getMedicalAccountFindByEmail(String email);
}
