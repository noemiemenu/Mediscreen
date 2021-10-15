package com.mediscreen.report.risks;

import com.mediscreen.report.interfaces.IRisk;
import com.mediscreen.report.model.PatientInfo;

public class None implements IRisk {

    @Override
    public String getRisk() {
        return "NONE";
    }

    @Override
    public boolean checkRisk(PatientInfo patientInfo, int numberOfTriggerTerms) {
        return numberOfTriggerTerms == 0;
    }
}
