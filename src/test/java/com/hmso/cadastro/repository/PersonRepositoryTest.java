package com.hmso.cadastro.repository;

import com.hmso.cadastro.dominio.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testSavePerson(){
        Person person = new Person();
        person.setNome("Roberto");
        person.setEmail("roberto@gmail.com");
        person.setIdade(26);
        person.setAltura(1.80);

        Person savedPerson = personRepository.save(person);

        assertNotNull(savedPerson.getId());
        assertEquals("Roberto", savedPerson.getNome());
    }

}