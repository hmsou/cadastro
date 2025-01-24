package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.dto.QuestionDto;
import com.hmso.cadastro.dominio.entities.Question;
import com.hmso.cadastro.mappers.QuestionMapper;
import com.hmso.cadastro.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    @PostMapping
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> findAllQuestions(){
        return new ResponseEntity<>(questionService.findAllQuestions()
                .stream()
                .map(questionMapper::toDto)
                .toList(), HttpStatus.OK);
    }

    @GetMapping(path = "{question_id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable Long question_id){
        return new ResponseEntity<>(questionService.findQuestionById(question_id), HttpStatus.OK);
    }

    @PutMapping(path = "/{question_id}")
    public ResponseEntity<Question> updateQuestion(
            @PathVariable Long question_id,
            @RequestBody Question question){
        return new ResponseEntity<>(questionService.updateQuestion(question_id, question), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{question_id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long question_id){
        questionService.deleteQuestion(question_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
