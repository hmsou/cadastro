package com.hmso.cadastro.mappers.impl;

import com.hmso.cadastro.dominio.dto.AnswerDto;
import com.hmso.cadastro.dominio.entities.Answer;
import com.hmso.cadastro.mappers.AnswerMapper;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapperImpl implements AnswerMapper {
    @Override
    public Answer fromDto(AnswerDto answerDto) {
        return new Answer(
                answerDto.id(),
                answerDto.text(),
                null,
                null
        );
    }

    @Override
    public AnswerDto toDto(Answer answer) {
        return new AnswerDto(
                answer.getId(),
                answer.getText()
        );
    }
}
