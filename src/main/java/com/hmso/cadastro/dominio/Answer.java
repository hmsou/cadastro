package com.hmso.cadastro.dominio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonManagedReference("person-answers")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonManagedReference("questions-answers")
    private Question perguntas;

    public Answer(Long id, String text, Person person, Question perguntas) {
        this.id = id;
        this.text = text;
        this.person = person;
        this.perguntas = perguntas;
    }

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Question getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(Question perguntas) {
        this.perguntas = perguntas;
    }
}
