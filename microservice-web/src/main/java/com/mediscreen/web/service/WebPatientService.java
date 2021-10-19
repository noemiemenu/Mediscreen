package com.mediscreen.web.service;

import com.mediscreen.web.model.Note;
import com.mediscreen.web.model.Patient;
import com.mediscreen.web.model.PatientInfo;
import com.mediscreen.web.proxies.NoteProxy;
import com.mediscreen.web.proxies.PatientProxy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * The type Web patient service.
 */
@Service
public class WebPatientService {

    private final PatientProxy patientProxy;
    private final NoteProxy noteProxy;


    /**
     * Instantiates a new Web patient service.
     *
     * @param patientProxy the patient proxy
     * @param noteProxy    the note proxy
     */
    public WebPatientService(PatientProxy patientProxy, NoteProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
    }


    /**
     * Patient info patient info.
     *
     * @param id the id
     * @return the patient info
     */
    public PatientInfo getPatientInfo(int id){
        Patient patient = patientProxy.getPatient(id);
        List<Note> notes = noteProxy.getAllNotesByPatId(id);
        int age = LocalDate.now().getYear() - patient.getDob().getYear();
        return new PatientInfo(notes, age, patient.getSex());
    }

    /**
     * Get patient by note id patient.
     *
     * @param id the id
     * @return the patient
     */
    public Patient getPatientByNoteId(int id){
        Note note = noteProxy.getNoteById(id);
        int patientId = note.getPatId();
        return patientProxy.getPatient(patientId);
    }
}
