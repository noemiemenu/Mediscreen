package com.mediscreen.web;

import com.mediscreen.web.controller.WebNoteController;
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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class WebNoteControllerTest {

    @InjectMocks
    private WebNoteController webNoteController;

    @MockBean
    private PatientProxy patientProxy;

    @MockBean
    private ReportProxy reportProxy;

    @MockBean
    private NoteProxy noteProxy;

    private MockMvc mockMvc;

    /**
     * Setup.
     */
    @BeforeEach
    public void setup() {
        webNoteController = new WebNoteController(noteProxy, patientProxy, new WebPatientService(patientProxy, noteProxy));
        mockMvc = MockMvcBuilders.standaloneSetup(webNoteController).build();
    }

    @Test
    public void testAddNote() throws Exception {
        // given
        Note note = new Note();
        note.setE("note");
        note.setId(1);
        note.setPatId(1);


        when(noteProxy.createNote(note.getPatId(), note.getE())).thenReturn(note);


        mockMvc.perform(MockMvcRequestBuilders.
                        post("/note/add/{patId}", 1
                        ))
                .andExpect(status().is3xxRedirection());
    }



}
