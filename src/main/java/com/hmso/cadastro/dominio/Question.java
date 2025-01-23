package com.hmso.cadastro.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "perguntas")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    public Question(Long id, String text) {
        this.id = id;
        this.text = text;
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
}
