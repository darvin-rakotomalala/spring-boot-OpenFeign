package com.poc.service.application;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.dto.NoteDTO;
import com.poc.service.bussinesdelegate.NoteMcsBDL;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteCUDSAImpl implements NoteCUDSA {

    @Value("${note.mcs.url}")
    private String noteBaseUrl;
    private final NoteMcsBDL noteMcsBDL;

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        try {
            log.info("----- createNote");
            return noteMcsBDL.createNote(noteDTO);
        } catch (Exception e) {
            log.error("Error createNote while calling WS : {}, message : {}", noteBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        try {
            log.info("----- updateNote");
            return noteMcsBDL.updateNote(noteDTO);
        } catch (Exception e) {
            log.error("Error updateNote while calling WS : {}, message : {}", noteBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public String deleteNoteById(Long id) {
        try {
            log.info("----- deleteNoteById : {}", id);
            return noteMcsBDL.deleteNoteById(id);
        } catch (Exception e) {
            log.error("Error deleteNoteById while calling WS : {}, message : {}", noteBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

}
