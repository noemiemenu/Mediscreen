package com.mediscreen.users.repositories;

import com.mediscreen.users.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Patient repository.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {

    /**
     * Find by id patient.
     *
     * @param id the id
     * @return the patient
     */
    Patient findById(int id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(int id);
}
