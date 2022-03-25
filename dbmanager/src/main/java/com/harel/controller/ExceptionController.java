package com.harel.controller;

import com.harel.exceptions.IdNumAlreadyExistsException;
import com.harel.exceptions.NullOrEmptyIdNumException;
import com.harel.exceptions.PersonNotFoundException;
import com.harel.model.dto.ResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = NullOrEmptyIdNumException.class)
    public ResponseDto nullOrEmptyIdNumException(NullOrEmptyIdNumException ex) {
        return new ResponseDto(ex.getReturnCode(), ex.getReturnDesc(), null);
    }

    @ExceptionHandler(value = IdNumAlreadyExistsException.class)
    public ResponseDto idNumAlreadyExistsException(IdNumAlreadyExistsException ex) {
        return new ResponseDto(ex.getReturnCode(), ex.getReturnDesc(), null);
    }

    @ExceptionHandler(value = PersonNotFoundException.class)
    public ResponseDto personNotFoundException(PersonNotFoundException ex) {
        return new ResponseDto(ex.getReturnCode(), ex.getReturnDesc(), null);
    }
}
