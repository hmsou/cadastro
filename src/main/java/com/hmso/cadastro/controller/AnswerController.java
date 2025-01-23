package com.hmso.cadastro.controller;

import com.hmso.cadastro.dominio.Answer;
import com.hmso.cadastro.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("answers")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public Answer addAnswer(@RequestBody Answer answer){
        return answerService.addAnswer(answer);
    }

    @GetMapping
    public List<Answer> findAnswers(){
        return answerService.findAnswers();
    }
}
