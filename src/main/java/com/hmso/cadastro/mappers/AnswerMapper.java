package com.hmso.cadastro.mappers;

import com.hmso.cadastro.dominio.dto.AnswerDto;
import com.hmso.cadastro.dominio.entities.Answer;

public interface AnswerMapper {
    Answer fromDto(AnswerDto answerDto);

    AnswerDto toDto(Answer answer);
}
