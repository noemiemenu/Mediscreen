package com.mediscreen.notes.interfaces;

import com.mediscreen.notes.model.Note;

public interface NoteService {
    Note updateNote(int id, Note note);
}
