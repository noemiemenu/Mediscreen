package com.mediscreen.notes.repository;

import com.mediscreen.notes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Note repository.
 */
@Repository

public interface NoteRepository extends MongoRepository<Note, Integer> {
    /**
     * Find all by pat id list.
     *
     * @param patId the pat id
     * @return the list
     */
    List<Note> findAllByPatId(int patId);

    /**
     * Find by id note.
     *
     * @param id the id
     * @return the note
     */
    Note findById(int id);
}
