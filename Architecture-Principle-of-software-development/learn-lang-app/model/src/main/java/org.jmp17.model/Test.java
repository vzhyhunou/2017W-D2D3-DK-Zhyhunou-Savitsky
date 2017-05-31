package org.jmp17.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Entity
@Table(name = "TEST")
public class Test extends BaseModelObj{
    private String name;
    @OneToMany(mappedBy = "testId")
    private List<Question> questions;
    private Integer topicId;

    public Integer getTopicId()
    {
        return topicId;
    }

    public void setTopicId( Integer topicId )
    {
        this.topicId = topicId;
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
