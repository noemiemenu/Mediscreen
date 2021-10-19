package com.mediscreen.web.proxies;

import com.mediscreen.web.config.FeignConfig;
import com.mediscreen.web.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The interface Note proxy.
 */
@FeignClient(name = "note-proxy-notes-api", url = "${notesAPI.service.url}", configuration = FeignConfig.class)
public interface NoteProxy {

    /**
     * Gets all notes by pat id.
     *
     * @param patId the pat id
     * @return the all notes by pat id
     */
    @GetMapping("/notes/{patId}")
    List<Note> getAllNotesByPatId(@PathVariable int patId);

    /**
     * Gets all notes.
     *
     * @return the all notes
     */
    @GetMapping("/notes")
    List<Note> getAllNotes();

    /**
     * Gets note by id.
     *
     * @param id the id
     * @return the note by id
     */
    @GetMapping("/note/{id}")
    Note getNoteById(@PathVariable int id);

    /**
     * Create note note.
     *
     * @param patId the pat id
     * @param e     the e
     * @return the note
     */
    @PostMapping("patHistory/add/{patId}")
    Note createNote(@PathVariable int patId, @RequestParam String e);

    /**
     * Update note note.
     *
     * @param id the id
     * @param e  the e
     * @return the note
     */
    @PatchMapping("/updateNote/{id}")
    Note updateNote(@PathVariable int id, @RequestParam String e);

    /**
     * Delete note by id.
     *
     * @param id the id
     */
    @DeleteMapping("/note/delete/{id}")
    void deleteNoteById(@PathVariable int id);

}
