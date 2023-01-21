package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import com.poc.service.bussinesdelegate.NoteMcsBDL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteRSAImpl implements NoteRSA {

    @Value("${note.mcs.url}")
    private String noteBaseUrl;
    private final NoteMcsBDL noteMcsBDL;

    @Override
    public NoteDTO getNoteById(Long id) {
        try {
            log.info("----- getNoteById : {}", id);
            return noteMcsBDL.getNoteById(id);
        } catch (Exception e) {
            log.error("Error getNoteById while calling WS : {}, message : {}", noteBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public NotePaginatedDTO getAllNotesByTitle(String title, int page, int size) {
        try {
            log.info("----- getAllNotesByTitle - title : {} page : {} size : {}", title, page, size);
            return noteMcsBDL.getAllNotesByTitle(title, page, size);
        } catch (Exception e) {
            log.error("Error getAllNotesByTitle while calling WS : {}, message : {}", noteBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

}
