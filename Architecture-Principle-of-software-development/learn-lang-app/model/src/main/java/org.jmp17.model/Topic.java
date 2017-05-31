package org.jmp17.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Entity
@Table(name = "TOPIC")
public class Topic extends BaseModelObj{
    private String name;
    private String description;

    @OneToMany(mappedBy = "topicId")
    private List<Test> tests;

    private Integer courseId;

    public Topic(Integer id, String name, String description, List<Test> tests) {
        super(id);
        this.name = name;
        this.description = description;
        this.tests = tests;
    }

    public Topic(String name, String description, List<Test> tests) {
        this.name = name;
        this.description = description;
        this.tests = tests;
    }

    public Topic( String name, String description, Integer courseId )
    {
        this.name = name;
        this.description = description;
        this.courseId = courseId;
    }

    public Topic()
    {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
