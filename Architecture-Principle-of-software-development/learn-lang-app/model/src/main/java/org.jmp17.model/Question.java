package org.jmp17.model;

import javax.persistence.*;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Entity
@Table(name = "QUESTION")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String questionText;
    private String[] answers;
    private String[] rightAnswers;
    private Integer testId;

    public Integer getTestId()
    {
        return testId;
    }

    public void setTestId( Integer testId )
    {
        this.testId = testId;
    }

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
