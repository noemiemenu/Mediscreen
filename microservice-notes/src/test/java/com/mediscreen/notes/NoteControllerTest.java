package com.mediscreen.notes;

import com.mediscreen.notes.config.NoteNextSequenceService;
import com.mediscreen.notes.controllers.NoteController;
import com.mediscreen.notes.interfaces.NoteService;
import com.mediscreen.notes.model.Note;
import com.mediscreen.notes.repository.NoteRepository;
import com.mediscreen.notes.services.NoteServiceIMPL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class NoteControllerTest {

    @MockBean
    private NoteRepository noteRepository;


    private NoteService noteService;

    @MockBean
    private NoteNextSequenceService noteNextSequenceService;



    @BeforeEach
    public void Setup() {
        noteService = new NoteServiceIMPL(noteRepository);
    }

    private MockMvc mockMvc;

    @InjectMocks
    private NoteController noteController;

    /**
     * Setup.
     */
    @BeforeEach
    public void setup() {
        noteController = new NoteController(noteRepository, noteService, noteNextSequenceService);
        mockMvc = MockMvcBuilders.standaloneSetup(noteController).build();
    }

    @Test
    public void testCreateNoteController() throws Exception {
        // given
        Note note = new Note();
        note.setId(0);
        note.setE("Test");
        note.setPatId(1);

        // when
        when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);

        mockMvc.perform(MockMvcRequestBuilders.
                        post("/patHistory/add/{patId}", note.getPatId()))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteNoteController() throws Exception {
        // given
        Note note = new Note();
        note.setId(1);
        note.setE("Test");
        note.setPatId(1);
        // when

        mockMvc.perform(MockMvcRequestBuilders.
                        delete("/note/delete/{id}", note.getId()))
                .andExpect(status().isOk());
    }


    @Test
    public void testUpdateNoteController() throws Exception {
        // given
        Note note = new Note();
        note.setId(1);
        note.setE("Test");
        note.setPatId(1);
        // when

        when(noteRepository.findById(anyInt())).thenReturn(note);

        mockMvc.perform(MockMvcRequestBuilders.
                        patch("/updateNote/{id}", note.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetNoteController() throws Exception {
        // given
        Note note = new Note();
        note.setId(1);
        note.setE("Test");
        note.setPatId(1);
        // when

        when(noteRepository.findById(anyInt())).thenReturn(note);

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/note/{id}", note.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllNotesController() throws Exception {
        // given
        Note note = new Note();
        note.setId(1);
        note.setE("Test");
        note.setPatId(1);
        // when

        when(noteRepository.findAll()).thenReturn(List.of(note));

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/notes"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllNotesByPatIdController() throws Exception {
        // given
        Note note = new Note();
        note.setId(1);
        note.setE("Test");
        note.setPatId(1);
        // when

        when(noteRepository.findAllByPatId(anyInt())).thenReturn(List.of(note));

        mockMvc.perform(MockMvcRequestBuilders.
                        get("/notes/{patId}", 1))
                .andExpect(status().isOk());
    }








}

