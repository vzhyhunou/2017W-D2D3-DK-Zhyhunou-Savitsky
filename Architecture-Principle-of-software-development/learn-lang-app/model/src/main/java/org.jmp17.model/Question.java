package org.jmp17.model;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Entity
@Table(name = "QUESTION")
public class Question extends BaseModelObj{
    private String questionText;
    @Lob
    private ArrayList<String> answers;
    @Lob
    private ArrayList<String> rightAnswers;
    private Integer testId;

    public Question( String questionText, ArrayList<String> answers,
      ArrayList<String> rightAnswers, Integer testId )
    {
        this.questionText = questionText;
        this.answers = answers;
        this.rightAnswers = rightAnswers;
        this.testId = testId;
    }

    public Question( String questionText, ArrayList<String> answers,
      ArrayList<String> rightAnswers )
    {
        this.questionText = questionText;
        this.answers = answers;
        this.rightAnswers = rightAnswers;
    }

    public Integer getTestId()
    {
        return testId;
    }

    public void setTestId( Integer testId )
    {
        this.testId = testId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getAnswers()
    {
        return answers;
    }

    public void setAnswers( ArrayList<String> answers )
    {
        this.answers = answers;
    }

    public ArrayList<String> getRightAnswers()
    {
        return rightAnswers;
    }

    public void setRightAnswers( ArrayList<String> rightAnswers )
    {
        this.rightAnswers = rightAnswers;
    }
}
