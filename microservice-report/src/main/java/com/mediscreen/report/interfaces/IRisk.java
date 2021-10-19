package com.mediscreen.report.interfaces;

import com.mediscreen.report.model.PatientInfo;

/**
 * The interface Risk.
 */
public interface IRisk {

    /**
     * Gets risk.
     *
     * @return the risk
     */
    String getRisk();

    /**
     * Check risk boolean.
     *
     * @param patientInfo          the patient info
     * @param numberOfTriggerTerms the number of trigger terms
     * @return the boolean
     */
    boolean checkRisk(PatientInfo patientInfo, int numberOfTriggerTerms);
}
