package com.harel.controller;

import com.harel.model.dto.PersonDto;
import com.harel.model.dto.ResponseDto;
import com.harel.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseDto insertPerson(@RequestBody PersonDto personDto) {
        return personService.insertPerson(personDto);
    }

    @GetMapping("/allPeople")
    public ResponseDto selectAllPeople() {
        return personService.selectAllPeople();
    }

    @GetMapping("/personById")
    public ResponseDto selectPersonById(@RequestBody PersonDto personDto) {
        return personService.selectPersonById(personDto);
    }

    @DeleteMapping
    public ResponseDto deletePersonById(@RequestBody PersonDto personDto) {
        return personService.deletePersonById(personDto);
    }

    @PutMapping
    public ResponseDto updatePersonById(@RequestBody PersonDto personDto) {
        return personService.updatePersonById(personDto);
    }
}
