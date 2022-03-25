package com.harel.service;

import com.harel.exceptions.IdNumAlreadyExistsException;
import com.harel.exceptions.NullOrEmptyIdNumException;
import com.harel.exceptions.PersonNotFoundException;
import com.harel.model.dto.ResponseDto;
import com.harel.model.entity.PersonEntity;
import com.harel.repository.PersonRepository;
import com.harel.model.dto.PersonDto;
import com.harel.utils.ExceptionMsg;
import com.harel.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(@Qualifier("RepositorySql") PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseDto insertPerson(PersonDto personDto) {
        ResponseDto resDto = null;
        Integer res = personRepository.insertPerson(Mapper.map(personDto));

        if (res == 0) {
            resDto = new ResponseDto(1,"Success",null);
        } else if (res == 1) {
            throw new NullOrEmptyIdNumException(ExceptionMsg.IDNUM_IS_NULL_OR_EMPTY);
        } else if (res == 2) {
            throw new IdNumAlreadyExistsException(ExceptionMsg.IDNUM_ALREADY_EXISTS);
        }

        return resDto;
    }

    public ResponseDto selectAllPeople() {
        List<PersonDto> res;
        ResponseDto resDto;
        res = personRepository.selectAllPeople().stream().map(Mapper::map).collect(Collectors.toList());
        resDto = new ResponseDto(0,"Success", res);

        return resDto;
    }

    public ResponseDto selectPersonById(PersonDto personDto) {
        ResponseDto resDto = null;
        Optional<PersonEntity> entity = personRepository.selectPersonById(personDto.getIdNum());
        PersonDto pd = entity.map(e -> Mapper.map(e)).orElse(null);

        if (pd != null) {
            resDto = new ResponseDto(1,"Success",pd);
        } else {
            throw new PersonNotFoundException(ExceptionMsg.PERSON_NOT_FOUND);
        }

        return resDto;
    }

    public ResponseDto deletePersonById(PersonDto personDto) {
        ResponseDto resDto = null;
        Boolean res = personRepository.deletePersonById(personDto.getIdNum());

        if (res) {
            resDto = new ResponseDto(1,"Success",null);
        } else {
            throw new PersonNotFoundException(ExceptionMsg.PERSON_NOT_FOUND);
        }
        return resDto;
    }

    public ResponseDto updatePersonById(PersonDto personDto) {
        ResponseDto resDto = null;
        Integer res = personRepository.updatePersonById(personDto.getIdNum(), Mapper.map(personDto));

        if (res == 0) {
            resDto = new ResponseDto(1,"Success",null);
        } else {
            throw new PersonNotFoundException(ExceptionMsg.PERSON_NOT_FOUND);
        }
        return resDto;
    }
}
