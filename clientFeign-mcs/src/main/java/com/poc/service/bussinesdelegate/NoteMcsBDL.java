package com.poc.service.bussinesdelegate;

import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "NoteBDL", url = "#{'${note.mcs.url}'}")
public interface NoteMcsBDL {

    @PostMapping(path = "/notes")
    public NoteDTO createNote(@RequestBody NoteDTO noteDTO);

    @PutMapping(path = "/notes")
    public NoteDTO updateNote(@RequestBody NoteDTO noteDTO);

    @DeleteMapping(path = "/notes/{id}")
    public String deleteNoteById(@PathVariable("id") Long id);

    @GetMapping(path = "/notes/{id}")
    public NoteDTO getNoteById(@PathVariable("id") Long id);

    @GetMapping(path = "/notes")
    public NotePaginatedDTO getAllNotesByTitle(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size);

}
