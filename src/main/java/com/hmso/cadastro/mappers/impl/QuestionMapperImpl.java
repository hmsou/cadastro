package com.hmso.cadastro.mappers.impl;

import com.hmso.cadastro.dominio.dto.QuestionDto;
import com.hmso.cadastro.dominio.entities.Question;
import com.hmso.cadastro.mappers.AnswerMapper;
import com.hmso.cadastro.mappers.QuestionMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class QuestionMapperImpl implements QuestionMapper {
    private final AnswerMapper answerMapper;

    public QuestionMapperImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public Question fromDto(QuestionDto questionDto) {
        return new Question(
                questionDto.id(),
                questionDto.text(),
                Optional.ofNullable(questionDto.answers())
                        .map(answers -> answers.stream()
                                .map(answerMapper::fromDto)
                                .toList()
                        ).orElse(null)
        );
    }

    @Override
    public QuestionDto toDto(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getText(),
                Optional.ofNullable(question.getAnswers())
                        .map(answers -> answers.stream()
                                .map(answerMapper::toDto)
                                .toList())
                        .orElse(null)
        );
    }
}
