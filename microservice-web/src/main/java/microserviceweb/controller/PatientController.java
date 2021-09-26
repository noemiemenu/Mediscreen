package microserviceweb.controller;

import microserviceweb.model.Patient;
import microserviceweb.proxies.MicroserviceUsersProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PatientController {

    @Autowired
    private MicroserviceUsersProxy microserviceUsersProxy;

    @GetMapping("/")
    public String listPatients(Model model){
        Collection<Patient> patientList = microserviceUsersProxy.patientsList();
        model.addAttribute("patients", patientList);
        return "homePage";
    }
}
