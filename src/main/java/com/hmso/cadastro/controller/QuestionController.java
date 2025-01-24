package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.entities.Question;
import com.hmso.cadastro.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @GetMapping
    public List<Question> findAllQuestions(){
        return questionService.findAllQuestions();
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
