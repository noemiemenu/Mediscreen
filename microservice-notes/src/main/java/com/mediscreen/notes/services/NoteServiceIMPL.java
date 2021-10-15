package com.mediscreen.notes.services;

import com.mediscreen.notes.interfaces.NoteService;
import com.mediscreen.notes.model.Note;
import com.mediscreen.notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

/**
 * The type Note service.
 */
@Service
public class NoteServiceIMPL implements NoteService {

    private final NoteRepository noteRepository;

    /**
     * Instantiates a new Note service.
     * @param noteRepository the note repository
     */
    public NoteServiceIMPL(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note updateNote(int id, Note note) {
        Note noteUpdate = noteRepository.findById(id);
        noteUpdate.setE(note.getE());
        return noteRepository.save(noteUpdate);
    }
}
