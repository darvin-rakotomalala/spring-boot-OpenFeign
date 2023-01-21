package com.poc.service.application;

import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;

public interface NoteRSA {
    public NoteDTO getNoteById(Long id);
    public NotePaginatedDTO getAllNotesByTitle(String title, int page, int size);
}
