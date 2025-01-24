package com.hmso.cadastro.mappers.impl;

import com.hmso.cadastro.dominio.dto.PersonDto;
import com.hmso.cadastro.dominio.entities.Person;
import com.hmso.cadastro.mappers.AnswerMapper;
import com.hmso.cadastro.mappers.PersonMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PersonMapperImpl implements PersonMapper {

    private final AnswerMapper answerMapper;

    public PersonMapperImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public Person fromDto(PersonDto personDto) {
        return new Person(
                personDto.id(),
                personDto.nome(),
                personDto.email(),
                personDto.idade(),
                personDto.altura(),
                Optional.ofNullable(personDto.answers())
                        .map(answers -> answers.stream()
                                .map(answerMapper::fromDto)
                                .toList()
                        ).orElse(null)
        );
    }

    @Override
    public PersonDto toDto(Person person) {
        return new PersonDto(
                person.getId(),
                person.getNome(),
                person.getEmail(),
                person.getIdade(),
                person.getAltura(),
                Optional.ofNullable(person.getAnswers())
                        .map(answers -> answers.stream()
                                .map(answerMapper::toDto)
                                .toList()
                        ).orElse(null)
        );
    }
}
