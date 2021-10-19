package com.mediscreen.web.model;

/**
 * The type Patient with report.
 */
public class PatientWithReport {

    private String report;

    private Patient patient;

    private int ageOfPatient;

    private int numberOfTriggerTerms;

    /**
     * Instantiates a new Patient with report.
     *
     * @param report               the report
     * @param patient              the patient
     * @param ageOfPatient         the age of patient
     * @param numberOfTriggerTerms the number of trigger terms
     */
    public PatientWithReport(String report, Patient patient, int ageOfPatient, int numberOfTriggerTerms) {
        this.report = report;
        this.patient = patient;
        this.ageOfPatient = ageOfPatient;
        this.numberOfTriggerTerms = numberOfTriggerTerms;
    }

    /**
     * Gets number of trigger terms.
     *
     * @return the number of trigger terms
     */
    public int getNumberOfTriggerTerms() {
        return numberOfTriggerTerms;
    }

    /**
     * Sets number of trigger terms.
     *
     * @param numberOfTriggerTerms the number of trigger terms
     */
    public void setNumberOfTriggerTerms(int numberOfTriggerTerms) {
        this.numberOfTriggerTerms = numberOfTriggerTerms;
    }

    /**
     * Gets patient.
     *
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Sets patient.
     *
     * @param patient the patient
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * Gets report.
     *
     * @return the report
     */
    public String getReport() {
        return report;
    }

    /**
     * Sets report.
     *
     * @param report the report
     */
    public void setReport(String report) {
        this.report = report;
    }

    /**
     * Gets age of patient.
     *
     * @return the age of patient
     */
    public int getAgeOfPatient() {
        return ageOfPatient;
    }

    /**
     * Sets age of patient.
     *
     * @param ageOfPatient the age of patient
     */
    public void setAgeOfPatient(int ageOfPatient) {
        this.ageOfPatient = ageOfPatient;
    }
}
