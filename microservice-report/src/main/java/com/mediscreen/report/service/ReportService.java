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

/**
 * The type Report service.
 */
@Service
public class ReportService {

    private final WebProxy webProxy;
    private final List<IRisk> risks = Arrays.asList(new None(), new Borderline(), new EarlyOnset(), new InDanger());

    /**
     * Instantiates a new Report service.
     *
     * @param webProxy the web proxy
     */
    public ReportService(WebProxy webProxy) {
        this.webProxy = webProxy;
    }


    /**
     * Number of trigger terms int.
     *
     * @param id the id
     * @return the int
     */
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

    /**
     * Gets type of risk.
     *
     * @param id the id
     * @return the type of risk
     */
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
