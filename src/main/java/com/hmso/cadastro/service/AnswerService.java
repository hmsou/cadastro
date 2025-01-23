package com.hmso.cadastro.service;

import com.hmso.cadastro.dominio.Answer;
import com.hmso.cadastro.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer addAnswer(Answer answer){
        if(answer.getId() != null){
            throw new IllegalArgumentException("Answer already got an ID");
        }
        answerRepository.save(new Answer(
                null,
                answer.getText()
        ));
        return answer;
    }

    public List<Answer> findAnswers(){
        return answerRepository.findAll();
    }

    public Answer updateAnswer(Long answerId, Answer answer){
        if(answer.getId() == null){
            throw new IllegalArgumentException("Answer must have an ID");
        }
        if(!Objects.equals(answerId, answer.getId())){
            throw new IllegalArgumentException("Can't change ID");
        }
        Answer existingAnswer = answerRepository.findById(answerId).orElseThrow(() -> new IllegalArgumentException("Not found"));

        existingAnswer.setText(answer.getText());

        return answerRepository.save(existingAnswer);
    }

    public void deleteAnswer(Long answerId){
        answerRepository.deleteById(answerId);
    }
}
