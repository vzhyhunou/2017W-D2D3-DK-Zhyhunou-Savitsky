package org.jmp17.model;

import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
public class Course extends BaseModelObj{
    private String name;
    private List<Topic> topics;

    public Course() {
    }

    public Course(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, List<Topic> topics) {
        this.name = name;
        this.topics = topics;
    }

    public Course(Integer id, String name, List<Topic> topics) {
        super(id);
        this.name = name;
        this.topics = topics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return  "id=" + getId() +
                ", name='" + name + '\'' +
                ", topics=" + topics;
    }
}
