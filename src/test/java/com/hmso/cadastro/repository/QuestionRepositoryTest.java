package com.hmso.cadastro.repository;

import com.hmso.cadastro.dominio.entities.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class QuestionRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void testSaveQuestion(){
        Question question = new Question();
        question.setText("What is your name?");

        Question savedQuestion = questionRepository.save(question);

        assertNotNull(savedQuestion.getId());
        assertEquals("What is your name?", savedQuestion.getText());
    }

    @Test
    public void testFindById(){
        Question question = new Question();
        question.setText("What is your name?");
        entityManager.persist(question);
        entityManager.flush();

        Optional<Question> foundQuestion = questionRepository.findById(question.getId());
        assertTrue(foundQuestion.isPresent());
        assertEquals("What is your name?", foundQuestion.get().getText());
    }

    @Test
    public void testDeleteQuestion() {
        Question question = new Question();
        question.setText("What is your name?");
        entityManager.persist(question);
        entityManager.flush();

        questionRepository.deleteById(question.getId());

        Optional<Question> deletedQuestion = questionRepository.findById(question.getId());

        assertFalse(deletedQuestion.isPresent());
    }
}