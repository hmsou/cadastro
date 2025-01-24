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
    public Answer addAnswer(@PathVariable Long person_id,
                            @PathVariable Long question_id,
                            @RequestBody Answer answer){
        return answerService.addAnswer(person_id, question_id, answer);
    }

    @GetMapping
    public List<Answer> findAnswers(){
        return answerService.findAnswers();
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
