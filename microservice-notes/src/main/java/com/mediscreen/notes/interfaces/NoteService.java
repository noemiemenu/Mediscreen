package com.mediscreen.notes.interfaces;

import com.mediscreen.notes.model.Note;

/**
 * The interface Note service.
 */
public interface NoteService {
    /**
     * Update note note.
     *
     * @param id   the id
     * @param note the note
     * @return the note
     */
    Note updateNote(int id, Note note);
}
