package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.Person;
import com.hmso.cadastro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> findAllPersons(){
        return personService.findPersons();
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
