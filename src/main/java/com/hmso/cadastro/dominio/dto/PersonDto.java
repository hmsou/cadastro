package com.hmso.cadastro.dominio.dto;

import java.util.List;

public record PersonDto(
        Long id,
        String nome,
        String email,
        int idade,
        double altura,
        List<AnswerDto> answers
) {
}
