package com.hmso.cadastro.service;

import com.hmso.cadastro.dominio.Person;
import com.hmso.cadastro.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public Person findPersonById(Long personId){
        return personRepository.findById(personId).orElseThrow(()-> new IllegalArgumentException("Not found"));
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
                person.getAltura(),
                null
        ));
        return person;
    }

    public Person updatePerson(Long personId, Person person){
        if (person.getId() == null){
            throw new IllegalArgumentException("Person must have and ID");
        }

        if(!Objects.equals(person.getId(), personId)){
            throw new IllegalArgumentException("Not permitted to change person ID");
        }

        Person existingPerson = personRepository.findById(personId).orElseThrow(() -> new IllegalArgumentException("Doesnt exist!"));

        existingPerson.setNome(person.getNome());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setIdade(person.getIdade());
        existingPerson.setAltura(person.getAltura());

        return personRepository.save(existingPerson);

    }

    @Transactional
    public void deletePerson(Long personId){
        personRepository.deleteById(personId);
    }
}
