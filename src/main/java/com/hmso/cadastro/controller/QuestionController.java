package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.dto.QuestionDto;
import com.hmso.cadastro.dominio.entities.Question;
import com.hmso.cadastro.mappers.QuestionMapper;
import com.hmso.cadastro.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping
    public List<QuestionDto> findAllQuestions(){
        return questionService.findAllQuestions()
                .stream()
                .map(questionMapper::toDto)
                .toList();
    }

    @GetMapping(path = "{question_id}")
    public Question findQuestionById(@PathVariable Long question_id){
        return questionService.findQuestionById(question_id);
    }

    @PutMapping(path = "/{question_id}")
    public Question updateQuestion(
            @PathVariable Long question_id,
            @RequestBody Question question){
        return questionService.updateQuestion(question_id, question);
    }

    @DeleteMapping(path = "/{question_id}")
    public void deleteQuestion(@PathVariable Long question_id){
        questionService.deleteQuestion(question_id);
    }
}
