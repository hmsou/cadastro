package com.hmso.cadastro.dominio.dto;

import java.util.List;

public record QuestionDto(
        Long id,
        String text,
        List<AnswerDto> answers
) {
}
