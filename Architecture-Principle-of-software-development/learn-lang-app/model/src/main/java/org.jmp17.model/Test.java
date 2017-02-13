package org.jmp17.model;

import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
public class Test {
    private Integer id;
    private String name;
    private List<Question> questions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
