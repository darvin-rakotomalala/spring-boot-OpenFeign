package com.poc.controller;

import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import com.poc.service.application.NoteCUDSA;
import com.poc.service.application.NoteRSA;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "notesClient")
public class NoteClientController {

    private final NoteCUDSA noteCUDSA;
    private final NoteRSA noteRSA;

    @Operation(summary = "WS used to create note")
    @PostMapping
    public NoteDTO createNote(@RequestBody NoteDTO noteDTO) {
        return noteCUDSA.createNote(noteDTO);
    }

    @Operation(summary = "WS used to update note")
    @PutMapping
    public NoteDTO updateNote(@RequestBody NoteDTO noteDTO) {
        return noteCUDSA.updateNote(noteDTO);
    }

    @Operation(summary = "WS used to delete note by id")
    @DeleteMapping("/{id}")
    public String deleteNoteById(@PathVariable("id") Long id) {
        return noteCUDSA.deleteNoteById(id);
    }

    @Operation(summary = "WS used to get note by id")
    @GetMapping("/{id}")
    public NoteDTO getNoteById(@PathVariable("id") Long id) {
        return noteRSA.getNoteById(id);
    }

    @Operation(summary = "WS used to get all notes")
    @GetMapping
    public NotePaginatedDTO getAllNotesByTitle(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "15", required = false) int size) {
        return noteRSA.getAllNotesByTitle(title, page, size);
    }

}
