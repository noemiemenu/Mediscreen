package com.mediscreen.notes.controllers;

import com.mediscreen.notes.interfaces.NoteService;
import com.mediscreen.notes.model.Note;
import com.mediscreen.notes.repository.NoteRepository;
import com.mediscreen.notes.services.NoteNextSequenceService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;
    private final NoteService noteService;
    private final NoteNextSequenceService noteNextSequenceService;

    public NoteController(NoteRepository noteRepository, NoteService noteService, NoteNextSequenceService noteNextSequenceService) {
        this.noteRepository = noteRepository;
        this.noteService = noteService;
        this.noteNextSequenceService = noteNextSequenceService;
    }

    @GetMapping("/notes/{patId}")
    public List<Note> getAllNotesByPatId(@PathVariable int patId) {
        return noteRepository.findAllByPatId(patId);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/note/{id}")
    public Note getNoteById(@PathVariable int id) {
        return noteRepository.findById(id);
    }

    @PostMapping("patHistory/add/{patId}")
    public Note createNote(@PathVariable int patId, @Valid Note note) {
        note.setId(noteNextSequenceService.getNextSequence("noteCustomSequences"));
        note.setPatId(patId);
        return noteRepository.save(note);
    }

    @PatchMapping("/updateNote/{id}")
    public Note updateNote(@PathVariable int id, @Valid Note note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/note/delete/{id}")
    public void deleteNoteById(@PathVariable int id) {
        noteRepository.deleteById(id);
    }
}
