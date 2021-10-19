package com.mediscreen.report.risks;

import com.mediscreen.report.interfaces.IRisk;
import com.mediscreen.report.model.PatientInfo;

/**
 * The type Early onset.
 */
public class EarlyOnset implements IRisk {

    public String getRisk() {
        return "Early onset";
    }

    public boolean checkRisk(PatientInfo patientInfo, int numberOfTriggerTerms) {
        boolean isMenAndBelowThirty = patientInfo.getSex().equals("M") && patientInfo.getAge() < 30 && numberOfTriggerTerms == 5;
        boolean isWomenAndBelowThirty = patientInfo.getSex().equals("F") && patientInfo.getAge() < 30 && numberOfTriggerTerms == 7;
        boolean aboveThirty = patientInfo.getAge() > 30 && numberOfTriggerTerms >= 8;

        return isMenAndBelowThirty || isWomenAndBelowThirty || aboveThirty;
    }
}
