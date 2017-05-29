package org.jmp17.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue
    private Integer id;
    private String questionText;
    private String[] answers;
    private String[] rightAnswers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String[] getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(String[] rightAnswers) {
        this.rightAnswers = rightAnswers;
    }
}
