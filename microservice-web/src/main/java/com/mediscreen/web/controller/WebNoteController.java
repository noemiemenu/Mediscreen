package com.mediscreen.web.controller;

import com.mediscreen.web.model.Note;
import com.mediscreen.web.model.Patient;
import com.mediscreen.web.proxies.NoteProxy;
import com.mediscreen.web.proxies.PatientProxy;
import com.mediscreen.web.service.WebPatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class WebNoteController {

    private final NoteProxy noteProxy;
    private final PatientProxy patientProxy;
    private final WebPatientService webPatientService;

    private final Logger logger = LoggerFactory.getLogger(WebNoteController.class);

    public WebNoteController(NoteProxy noteProxy, PatientProxy patientProxy, WebPatientService webPatientService) {
        this.noteProxy = noteProxy;
        this.patientProxy = patientProxy;
        this.webPatientService = webPatientService;
    }

    @GetMapping("/note/notes/{patId}")
    public String getAllNotesByPatId(@PathVariable int patId, Model model){
        model.addAttribute("patient", patientProxy.getPatient(patId));
        model.addAttribute("notes", noteProxy.getAllNotesByPatId(patId));
        return "note/notes";

    }

    @GetMapping("/note/add/{patId}")
    public String showAddPatientForm(@PathVariable int patId, Model model) {
        model.addAttribute("patient", patientProxy.getPatient(patId));
        model.addAttribute("patId", patId);
        return "note/add";
    }

    @PostMapping("/note/add/{patId}")
    public String createNote(@PathVariable int patId,@Valid String e){
        logger.info("patient id: " + patId);
        logger.info("Note " + e);
        noteProxy.createNote(patId, e);
        return "redirect:/note/notes/" + patId;
    }

    @GetMapping("/note/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Note note = noteProxy.getNoteById(id);
        Patient patient = webPatientService.getPatientByNoteId(id);
        model.addAttribute("note", note);
        model.addAttribute("patient", patient);
        logger.info("Note id from microservice-notes: " + note.getId());
        return "note/update";
    }

    @PostMapping("/note/update/{id}")
    public String updateNote(@PathVariable int id, @Valid Note note){
        logger.info("note id: " + note.getId());
        Note noteId = noteProxy.getNoteById(id);
        noteProxy.updateNote(id, note.getE());
        return "redirect:/note/notes/" + noteId.getPatId();
    }

    @GetMapping("/note/delete/{id}")
    public String deleteNote(@PathVariable int id){
        logger.info("note id: " + id);
        Note noteId = noteProxy.getNoteById(id);
        noteProxy.deleteNoteById(id);
        return "redirect:/note/notes/" + noteId.getPatId();
    }
}
