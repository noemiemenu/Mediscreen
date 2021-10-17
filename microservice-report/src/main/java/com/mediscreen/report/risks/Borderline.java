package com.mediscreen.report.risks;

import com.mediscreen.report.interfaces.IRisk;
import com.mediscreen.report.model.PatientInfo;

public class Borderline implements IRisk {

    @Override
    public String getRisk() {
        return "Borderline";
    }

    @Override
    public boolean checkRisk(PatientInfo patientInfo, int numberOfTriggerTerms) {
        return numberOfTriggerTerms == 2 && patientInfo.getAge() > 30;
    }
}
