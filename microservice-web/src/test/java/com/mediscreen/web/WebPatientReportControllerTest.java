package com.mediscreen.web;

import com.mediscreen.web.controller.WebPatientReportController;
import com.mediscreen.web.model.Note;
import com.mediscreen.web.model.Patient;
import com.mediscreen.web.proxies.NoteProxy;
import com.mediscreen.web.proxies.PatientProxy;
import com.mediscreen.web.proxies.ReportProxy;
import com.mediscreen.web.service.WebPatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class WebPatientReportControllerTest {

    @MockBean
    private PatientProxy patientProxy;

    @MockBean
    private NoteProxy noteProxy;


    private MockMvc mockMvc;

    @InjectMocks
    private WebPatientReportController webPatientReportController;

    /**
     * Setup.
     */
    @BeforeEach
    public void setup() {
        webPatientReportController = new WebPatientReportController(new WebPatientService(patientProxy, noteProxy));
        mockMvc = MockMvcBuilders.standaloneSetup(webPatientReportController).build();
    }

    @Test
    public void TestGetPatientInfoController() throws Exception {
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

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/patientInfo/{id}", patientId.getId()))
                .andExpect(status().isOk());
    }

}
