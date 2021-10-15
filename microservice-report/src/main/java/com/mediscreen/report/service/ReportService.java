package com.mediscreen.report.service;

import com.mediscreen.report.interfaces.IRisk;
import com.mediscreen.report.model.PatientInfo;
import com.mediscreen.report.model.TriggerTerms;
import com.mediscreen.report.proxies.WebProxy;
import com.mediscreen.report.risks.Borderline;
import com.mediscreen.report.risks.EarlyOnset;
import com.mediscreen.report.risks.InDanger;
import com.mediscreen.report.risks.None;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class ReportService {

    private final WebProxy webProxy;
    private final List<IRisk> risks = Arrays.asList(new None(), new Borderline(), new EarlyOnset(), new InDanger());

    public ReportService(WebProxy webProxy) {
        this.webProxy = webProxy;
    }


    public int numberOfTriggerTerms(int id){
        List<String> notes = webProxy.getPatientInfo(id).getNotes();
        int triggerTerms = 0;
        for (String note : notes) {
            for (String triggerTerm : TriggerTerms.Terms) {
                if (note.toLowerCase(Locale.ROOT).contains(triggerTerm.toLowerCase(Locale.ROOT))){
                    triggerTerms++;
                }
            }
        }
        return triggerTerms;
    }

    public String getTypeOfRisk(int id) {
        PatientInfo patientInfo = webProxy.getPatientInfo(id);
        int numberOfTriggerTerms = numberOfTriggerTerms(id);

        for (IRisk risk : risks) {
            if (risk.checkRisk(patientInfo, numberOfTriggerTerms)) {
                return risk.getRisk();
            }
        }
        return "NONE";
    }

}
