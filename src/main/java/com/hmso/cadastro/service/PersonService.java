package com.hmso.cadastro.service;

import com.hmso.cadastro.dominio.Person;
import com.hmso.cadastro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findPersons(){
        return personRepository.findAll();
    }
}
