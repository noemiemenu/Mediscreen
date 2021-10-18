package com.mediscreen.web.model;

public class PatientWithReport {

    private String report;

    private Patient patient;

    private int ageOfPatient;

    private int numberOfTriggerTerms;

    public PatientWithReport(String report, Patient patient, int ageOfPatient, int numberOfTriggerTerms) {
        this.report = report;
        this.patient = patient;
        this.ageOfPatient = ageOfPatient;
        this.numberOfTriggerTerms = numberOfTriggerTerms;
    }

    public int getNumberOfTriggerTerms() {
        return numberOfTriggerTerms;
    }

    public void setNumberOfTriggerTerms(int numberOfTriggerTerms) {
        this.numberOfTriggerTerms = numberOfTriggerTerms;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public int getAgeOfPatient() {
        return ageOfPatient;
    }

    public void setAgeOfPatient(int ageOfPatient) {
        this.ageOfPatient = ageOfPatient;
    }
}
