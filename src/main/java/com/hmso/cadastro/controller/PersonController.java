package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.dto.PersonDto;
import com.hmso.cadastro.dominio.entities.Person;
import com.hmso.cadastro.mappers.PersonMapper;
import com.hmso.cadastro.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "persons")
public class PersonController {
    private final PersonService personService;
    private final PersonMapper personMapper;

    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @PostMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        return new ResponseEntity<>(personService.addPerson(person), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAllPersonList(){
        return new ResponseEntity<>(personService.findPersonList()
                .stream()
                .map(personMapper::toDto)
                .toList(), HttpStatus.OK);
    }

    @GetMapping(path = "/{person_id}")
    public ResponseEntity<Person> findPersonById(@PathVariable Long person_id){
        return new ResponseEntity<>(personService.findPersonById(person_id), HttpStatus.OK);
    }

    @PutMapping(path = "/{person_id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable Long person_id,
            @RequestBody Person person
    ){
        return new ResponseEntity<>(personService.updatePerson(person_id, person), HttpStatus.OK);
    }

    @DeleteMapping("/{person_id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long person_id){
        personService.deletePerson(person_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
