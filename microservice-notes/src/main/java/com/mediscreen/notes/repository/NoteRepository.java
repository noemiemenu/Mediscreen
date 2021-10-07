package com.mediscreen.notes.repository;

import com.mediscreen.notes.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, Integer> {
    List<Note> findAllByPatId(int patId);
    Note findById(int id);
}
