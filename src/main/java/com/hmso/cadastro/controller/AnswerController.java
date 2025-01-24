package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.dto.AnswerDto;
import com.hmso.cadastro.dominio.entities.Answer;
import com.hmso.cadastro.mappers.AnswerMapper;
import com.hmso.cadastro.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answers")
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }


    @PostMapping(path= "/{person_id}/{question_id}")
    public Answer addAnswer(@PathVariable Long person_id,
                            @PathVariable Long question_id,
                            @RequestBody Answer answer){
        return answerService.addAnswer(person_id, question_id, answer);
    }

    @GetMapping
    public List<AnswerDto> findAnswers(){

        return answerService.findAnswers()
                .stream()
                .map(answerMapper::toDto)
                .toList();
    }

    @GetMapping(path = "{answer_id}")
    public Answer findAnswerById(@PathVariable Long answer_id){
        return answerService.findAnswerById(answer_id);
    }

    @PutMapping(path = "/{answer_id}")
    public Answer updateAnswer(
            @PathVariable Long answer_id,
            @RequestBody Answer answer){
        return answerService.updateAnswer(answer_id, answer);
    }

    @DeleteMapping(path = "/{answer_id}")
    public void deleteAnswer(@PathVariable Long answer_id){
        answerService.deleteAnswer(answer_id);
    }
}
