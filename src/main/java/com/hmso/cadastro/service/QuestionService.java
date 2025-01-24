package com.hmso.cadastro.service;

import com.hmso.cadastro.dominio.entities.Question;
import com.hmso.cadastro.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question addQuestion(Question question){
        if(question.getId() != null){
            throw new IllegalArgumentException("Question already has an ID");
        }

        questionRepository.save(new Question(
                null,
                question.getText(),
                null
        ));
        return question;
    }

    public List<Question> findAllQuestions(){
        return questionRepository.findAll();
    }

    public Question findQuestionById(Long questionId){
        return questionRepository.findById(questionId).orElseThrow(()-> new IllegalArgumentException("Not found"));
    }

    public Question updateQuestion(Long questionId, Question question){
        Question existingQuestion = questionRepository.findById(questionId).orElseThrow(() -> new IllegalArgumentException("Not found"));

        existingQuestion.setText(question.getText());

        return questionRepository.save(existingQuestion);
    }

    public void deleteQuestion(Long questionId){
        questionRepository.deleteById(questionId);
    }


}
