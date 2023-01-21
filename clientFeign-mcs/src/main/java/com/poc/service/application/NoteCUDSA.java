package com.poc.service.application;

import com.poc.model.dto.NoteDTO;

public interface NoteCUDSA {
    public NoteDTO createNote(NoteDTO noteDTO);
    public NoteDTO updateNote(NoteDTO noteDTO);
    public String deleteNoteById(Long id);
}
