package com.hmso.cadastro.mappers;

import com.hmso.cadastro.dominio.dto.PersonDto;
import com.hmso.cadastro.dominio.entities.Person;

public interface PersonMapper {
    Person fromDto(PersonDto personDto);

    PersonDto toDto(Person person);
}
