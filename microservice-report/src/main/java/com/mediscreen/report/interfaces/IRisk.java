package com.mediscreen.report.interfaces;

import com.mediscreen.report.model.PatientInfo;

public interface IRisk {

    String getRisk();

    boolean checkRisk(PatientInfo patientInfo, int numberOfTriggerTerms);
}
