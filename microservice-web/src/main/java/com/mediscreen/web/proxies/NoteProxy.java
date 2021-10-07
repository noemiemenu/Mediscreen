package com.mediscreen.web.proxies;

import com.mediscreen.web.config.FeignConfig;
import com.mediscreen.web.model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "note-proxy-notes-api", url = "${notesAPI.service.url}", configuration = FeignConfig.class)
public interface NoteProxy {

    @GetMapping("/notes/{patId}")
    List<Note> getAllNotesByPatId(@PathVariable int patId);

    @GetMapping("/notes")
    List<Note> getAllNotes();

    @GetMapping("/note/{id}")
    Note getNoteById(@PathVariable int id);

    @PostMapping("patHistory/add/{patId}")
    Note createNote(@PathVariable int patId, @RequestParam String e);

    @PatchMapping("/updateNote/{id}")
    Note updateNote(@PathVariable int id, @RequestParam String e);

    @DeleteMapping("/note/delete/{id}")
    void deleteNoteById(@PathVariable int id);

}
