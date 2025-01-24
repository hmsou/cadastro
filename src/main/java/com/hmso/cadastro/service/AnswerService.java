package com.hmso.cadastro.service;

import com.hmso.cadastro.dominio.Answer;
import com.hmso.cadastro.dominio.Person;
import com.hmso.cadastro.dominio.Question;
import com.hmso.cadastro.repository.AnswerRepository;
import com.hmso.cadastro.repository.PersonRepository;
import com.hmso.cadastro.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final PersonRepository personRepository;
    private final QuestionRepository questionRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, PersonRepository personRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.personRepository = personRepository;
        this.questionRepository = questionRepository;
    }

    public Answer addAnswer(Long personId, Long questionId, Answer answer){
        if(answer.getId() != null){
            throw new IllegalArgumentException("Answer already got an ID");
        }

        Person person = personRepository.findById(personId).orElseThrow(() -> new IllegalArgumentException("Person not found"));
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new IllegalArgumentException("Question not found"));

        answerRepository.save(new Answer(
                null,
                answer.getText(),
                person,
                question
        ));
        return answer;
    }

    public List<Answer> findAnswers(){
        return answerRepository.findAll();
    }

    public Answer findAnswerById(Long answerId){
        return answerRepository.findById(answerId).orElseThrow(() -> new IllegalArgumentException("Not found"));
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
