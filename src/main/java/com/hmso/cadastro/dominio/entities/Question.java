package com.hmso.cadastro.dominio.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perguntas")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @OneToMany(mappedBy = "perguntas", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Question(Long id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }

    public Question() {
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
