package com.hmso.cadastro.dominio;

import jakarta.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long text;

    public Answer(Long id, Long text) {
        this.id = id;
        this.text = text;
    }

    public Answer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getText() {
        return text;
    }

    public void setText(Long text) {
        this.text = text;
    }
}
