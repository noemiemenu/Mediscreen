package com.mediscreen.notes;

import com.mediscreen.notes.interfaces.NoteService;
import com.mediscreen.notes.model.Note;
import com.mediscreen.notes.repository.NoteRepository;
import com.mediscreen.notes.services.NoteServiceIMPL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The type Notes tests.
 */
@SpringBootTest
public class NotesTests {

    @MockBean
    private NoteRepository noteRepository;

    private NoteService noteService;

    /**
     * Setup.
     */
    @BeforeEach
    public void Setup() {
        noteService = new NoteServiceIMPL(noteRepository);
    }

    /**
     * Test create note.
     */
    @Test
    public void testCreateNote(){
        // given
        Note note = new Note();
        note.setId(0);
        note.setE("Test");
        note.setPatId(1);

        // when
        when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);
        Note saveNote = noteRepository.save(note);

        Assertions.assertNotNull(saveNote);
        Assertions.assertEquals(saveNote.getE(), "Test");
        Assertions.assertEquals(saveNote.getId(), 0);
        Assertions.assertEquals(saveNote.getPatId(), 1);
        verify(noteRepository).save(Mockito.any(Note.class));

    }

    /**
     * Test update note.
     */
    @Test
    public void testUpdateNote() {
        // given
        Note note = new Note();
        note.setE("Test");

        // when
        when(noteRepository.save(Mockito.any(Note.class))).thenReturn(note);
        when(noteRepository.findById(Mockito.anyInt())).thenReturn(note);
        Note savedNotes = noteService.updateNote(1, note);


        // then
        Assertions.assertNotNull(savedNotes);
        Assertions.assertEquals(savedNotes.getE(), "Test");
        verify(noteRepository).findById(anyInt());
        verify(noteRepository).save(Mockito.any(Note.class));
    }

    /**
     * Test get note.
     */
    @Test
    public void testGetNote() {
        // given
        Note note = new Note();
        note.setE("Test");
        note.setId(1);
        note.setPatId(2);

        // when
        when(noteRepository.findById(Mockito.anyInt())).thenReturn(note);
        Note savedNote = noteRepository.findById(1);


        // then
        Assertions.assertNotNull(savedNote);
        Assertions.assertEquals(savedNote.getE(), "Test");
        Assertions.assertEquals(savedNote.getId(), 1);
        Assertions.assertEquals(savedNote.getPatId(), 2);
        verify(noteRepository).findById(anyInt());
    }

    /**
     * Test delete patient.
     */
    @Test
    public void testDeletePatient() {
        // when
        noteRepository.deleteById(1);


        // then
        verify(noteRepository).deleteById(anyInt());
    }

    /**
     * Test get all patients.
     */
    @Test
    public void testGetAllPatients() {
        // given
        Note note = new Note();
        note.setE("Test");
        note.setId(1);
        note.setPatId(2);
        List<Note> noteList = new ArrayList<>();
        noteList.add(note);
        when(noteRepository.findAll()).thenReturn(noteList);

        // when
        Collection<Note> notes = noteRepository.findAll();

        // then
        Assertions.assertEquals(notes.size(), 1);
        Assertions.assertEquals(notes.iterator().next().getId(), 1);
    }

}
