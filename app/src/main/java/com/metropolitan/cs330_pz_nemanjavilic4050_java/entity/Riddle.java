package com.metropolitan.cs330_pz_nemanjavilic4050_java.entity;

import androidx.annotation.NonNull;

import java.util.Date;

public class Riddle {

    private int id;
    private String question;
    private String answer;

    public Riddle() { }

    public Riddle(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Riddle(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Riddle{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
