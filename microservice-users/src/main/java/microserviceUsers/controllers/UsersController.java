package microserviceUsers.controllers;

import microserviceUsers.interfaces.UsersService;
import microserviceUsers.models.Patient;
import microserviceUsers.repositories.UsersRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UsersController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;

    public UsersController(UsersService usersService, UsersRepository usersRepository, UsersRepository usersRepository1) {
        this.usersService = usersService;
        this.usersRepository = usersRepository1;
    }

    @GetMapping("/patient")
    public Iterable<Patient> patientList(){
        return usersRepository.findAll();
    }

    @PostMapping("/patient/add")
    public Patient addPatient(Patient patient){
        return usersService.addPatient(patient);
    }

    @PatchMapping("/patient/update/{id}")
    public Patient updatePatient(@PathVariable int id, @Valid Patient patient){
        return usersService.updatePatient(id, patient);
    }

    @DeleteMapping("/patient/delete/{id}")
    public void deletePatient(@PathVariable int id){
        usersService.deletePatient(id);
    }
}
