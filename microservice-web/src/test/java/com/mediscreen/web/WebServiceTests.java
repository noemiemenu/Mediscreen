package com.mediscreen.web;

import com.mediscreen.web.model.Note;
import com.mediscreen.web.model.Patient;
import com.mediscreen.web.model.PatientInfo;
import com.mediscreen.web.proxies.NoteProxy;
import com.mediscreen.web.proxies.PatientProxy;
import com.mediscreen.web.service.WebPatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * The type Microservice web application tests.
 */
@SpringBootTest
class WebServiceTests {

    private WebPatientService webPatientService;

    @MockBean
    private PatientProxy patientProxy;

    @MockBean
    private NoteProxy noteProxy;

    @BeforeEach
    public void Setup() {
        webPatientService = new WebPatientService(patientProxy, noteProxy);
    }

    @Test
    public void getPatientByNoteIdTest(){
        //given
        Note note = new Note();
        note.setId(1);
        note.setPatId(1);

        Patient patientId = new Patient();
        patientId.setId(1);
        patientId.setFirstName("Noémie");
        //when
        when(noteProxy.getNoteById(anyInt())).thenReturn(note);
        when(patientProxy.getPatient(anyInt())).thenReturn(patientId);
        Patient patient = webPatientService.getPatientByNoteId(1);

        //then
        Assertions.assertEquals(1, patient.getId());
    }

    @Test
    public void getPatientInfoWhitPatientId(){
        //given
        Patient patientId = new Patient();
        patientId.setId(1);
        patientId.setSex("F");
        patientId.setDob(LocalDate.of(1996, 7, 30));

        Note note1 = new Note();
        note1.setPatId(1);
        note1.setId(1);
        note1.setE("Note1");

        Note note2 = new Note();
        note2.setPatId(1);
        note2.setId(2);
        note2.setE("Note2");

        List<Note> notes = Arrays.asList(note1, note2);

        //when
        when(noteProxy.getAllNotesByPatId(anyInt())).thenReturn(notes);
        when(patientProxy.getPatient(anyInt())).thenReturn(patientId);
        PatientInfo patientInfo = webPatientService.getPatientInfo(1);

        //then
        Assertions.assertEquals("F", patientInfo.getSex());
        Assertions.assertEquals(25, patientInfo.getAge());


    }

}
