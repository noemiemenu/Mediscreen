package com.mediscreen.users.repositories;

import com.mediscreen.users.models.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

    Patient findById(int id);

    void deleteById(int id);
}
