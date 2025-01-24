package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.dto.PersonDto;
import com.hmso.cadastro.dominio.entities.Person;
import com.hmso.cadastro.mappers.PersonMapper;
import com.hmso.cadastro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<PersonDto> findAllPersons(){
        return personService.findPersons()
                .stream()
                .map(personMapper::toDto)
                .toList();
    }

    @GetMapping(path = "/{person_id}")
    public Person findPersonById(@PathVariable Long person_id){
        return personService.findPersonById(person_id);
    }

    @PutMapping(path = "/{person_id}")
    public Person updatePerson(
            @PathVariable Long person_id,
            @RequestBody Person person
    ){
        return personService.updatePerson(person_id, person);
    }

    @DeleteMapping("/{person_id}")
    public void deletePerson(@PathVariable Long person_id){
        personService.deletePerson(person_id);
    }
}
