package com.hmso.cadastro.dominio.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private int idade;
    private double altura;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Answer> answers;

    public Person(Long id, String nome, String email, int idade, double altura, List<Answer> answers) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.altura = altura;
        this.answers = answers;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
