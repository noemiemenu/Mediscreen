package com.mediscreen.report.risks;

import com.mediscreen.report.interfaces.IRisk;
import com.mediscreen.report.model.PatientInfo;

/**
 * The type In danger.
 */
public class InDanger implements IRisk {


    public String getRisk() {
        return "In Danger";
    }

    public boolean checkRisk(PatientInfo patientInfo, int numberOfTriggerTerms) {
        boolean isWomenAndBelowThirty = patientInfo.getSex().equals("F") && patientInfo.getAge() < 30 && numberOfTriggerTerms == 4;
        boolean isMenAndBelowThirty = patientInfo.getSex().equals("M") && patientInfo.getAge() < 30 && numberOfTriggerTerms == 3;
        boolean aboveThirty = patientInfo.getAge() > 30 && numberOfTriggerTerms == 6;

        return isMenAndBelowThirty || isWomenAndBelowThirty || aboveThirty;
    }
}
