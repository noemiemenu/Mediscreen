package com.mediscreen.users.interfaces;


import com.mediscreen.users.models.Patient;

import java.util.Collection;

/**
 * The interface Patient service.
 */
public interface PatientService {

    /**
     * Add patient patient.
     *
     * @param patient the patient
     * @return the patient
     */
    Patient addPatient(Patient patient);

    /**
     * Update patient patient.
     *
     * @param id      the id
     * @param patient the patient
     * @return the patient
     */
    Patient updatePatient(int id, Patient patient);

    /**
     * Delete patient.
     *
     * @param id the id
     */
    void deletePatient(int id);

    /**
     * Patients list collection.
     *
     * @return the collection
     */
    Collection<Patient> patientsList();

    /**
     * Gets patient.
     *
     * @param id the id
     * @return the patient
     */
    Patient getPatient(int id);
}
