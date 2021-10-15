package com.mediscreen.web.service;

import com.mediscreen.web.model.Note;
import com.mediscreen.web.model.Patient;
import com.mediscreen.web.model.PatientInfo;
import com.mediscreen.web.proxies.NoteProxy;
import com.mediscreen.web.proxies.PatientProxy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientInfoService {

    private final PatientProxy patientProxy;
    private final NoteProxy noteProxy;


    public PatientInfoService(PatientProxy patientProxy, NoteProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
    }


    public PatientInfo patientInfo(int id){
        Patient patient = patientProxy.getPatient(id);
        List<Note> notes = noteProxy.getAllNotesByPatId(id);
        int age = LocalDate.now().getYear() - patient.getDob().getYear();
        return new PatientInfo(notes, age, patient.getSex());
    }
}
