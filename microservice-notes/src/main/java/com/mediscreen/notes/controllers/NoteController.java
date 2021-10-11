package com.mediscreen.notes.controllers;

import com.mediscreen.notes.interfaces.NoteService;
import com.mediscreen.notes.model.Note;
import com.mediscreen.notes.repository.NoteRepository;
import com.mediscreen.notes.services.NoteNextSequenceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Note controller.
 */
@RestController
public class NoteController {

    private final NoteRepository noteRepository;
    private final NoteService noteService;
    private final NoteNextSequenceService noteNextSequenceService;

    /**
     * Instantiates a new Note controller.
     *
     * @param noteRepository          the note repository
     * @param noteService             the note service
     * @param noteNextSequenceService the note next sequence service
     */
    public NoteController(NoteRepository noteRepository, NoteService noteService, NoteNextSequenceService noteNextSequenceService) {
        this.noteRepository = noteRepository;
        this.noteService = noteService;
        this.noteNextSequenceService = noteNextSequenceService;
    }

    /**
     * Gets all notes by pat id.
     *
     * @param patId the pat id
     * @return the all notes by pat id
     */
    @GetMapping("/notes/{patId}")
    public List<Note> getAllNotesByPatId(@PathVariable int patId) {
        return noteRepository.findAllByPatId(patId);
    }

    /**
     * Gets all notes.
     *
     * @return the all notes
     */
    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Gets note by id.
     *
     * @param id the id
     * @return the note by id
     */
    @GetMapping("/note/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteRepository.findById(id);
    }

    /**
     * Create note note.
     *
     * @param patId the pat id
     * @param note  the note
     * @return the note
     */
    @PostMapping("patHistory/add/{patId}")
    public Note createNote(@PathVariable int patId, @Valid Note note) {
        note.setId(noteNextSequenceService.getNextSequence("noteCustomSequences"));
        note.setPatId(patId);
        return noteRepository.save(note);
    }

    /**
     * Update note note.
     *
     * @param id   the id
     * @param note the note
     * @return the note
     */
    @PatchMapping("/updateNote/{id}")
    public Note updateNote(@PathVariable int id, @Valid Note note) {
        return noteService.updateNote(id, note);
    }

    /**
     * Delete note by id.
     *
     * @param id the id
     */
    @DeleteMapping("/note/delete/{id}")
    public void deleteNoteById(@PathVariable int id) {
        noteRepository.deleteById(id);
    }
}
