package com.mediscreen.notes.services;

import com.mediscreen.notes.interfaces.NoteService;
import com.mediscreen.notes.model.Note;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceIMPL implements NoteService {

    @Override
    public Note updateNote(int id, Note note) {
        Note noteUpdate = new Note();
        noteUpdate.setE(note.getE());
        return noteUpdate;
    }
}
