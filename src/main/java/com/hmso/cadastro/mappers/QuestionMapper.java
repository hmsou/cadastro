package com.hmso.cadastro.mappers;

import com.hmso.cadastro.dominio.dto.QuestionDto;
import com.hmso.cadastro.dominio.entities.Question;

public interface QuestionMapper {
    Question fromDto(QuestionDto questionDto);

    QuestionDto toDto(Question question);
}
