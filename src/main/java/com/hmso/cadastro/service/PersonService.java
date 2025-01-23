package com.hmso.cadastro.service;

import com.hmso.cadastro.dominio.Person;
import com.hmso.cadastro.repository.PersonRepository;
import jakarta.transaction.Transactional;
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

    public Person addPerson(Person person){
        if(person.getId() != null) {
            throw new IllegalArgumentException("Person already has an ID");
        }

        personRepository.save(new Person(
                null,
                person.getNome(),
                person.getEmail(),
                person.getIdade(),
                person.getAltura()
        ));
        return person;
    }

    @Transactional
    public void deletePerson(String personName){
        personRepository.deleteById(personName);
    }
}
