package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.dto.AnswerDto;
import com.hmso.cadastro.dominio.entities.Answer;
import com.hmso.cadastro.mappers.AnswerMapper;
import com.hmso.cadastro.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Answer> addAnswer(@PathVariable Long person_id,
                                           @PathVariable Long question_id,
                                           @RequestBody Answer answer){
        return new ResponseEntity<>(answerService.addAnswer(person_id, question_id, answer), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnswerDto>> findAnswers(){

        return new ResponseEntity<>(answerService.findAnswers()
                .stream()
                .map(answerMapper::toDto)
                .toList(), HttpStatus.OK);
    }

    @GetMapping(path = "{answer_id}")
    public ResponseEntity<Answer> findAnswerById(@PathVariable Long answer_id){
        return new ResponseEntity<>(answerService.findAnswerById(answer_id), HttpStatus.OK);
    }

    @PutMapping(path = "/{answer_id}")
    public ResponseEntity<Answer> updateAnswer(
            @PathVariable Long answer_id,
            @RequestBody Answer answer){
        return new ResponseEntity<>(answerService.updateAnswer(answer_id, answer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{answer_id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long answer_id){
        answerService.deleteAnswer(answer_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
