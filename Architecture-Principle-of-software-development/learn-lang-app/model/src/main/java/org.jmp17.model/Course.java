package org.jmp17.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@MappedSuperclass
public class Course extends BaseModelObj{
    private String name;
    @OneToMany(mappedBy = "courseId")
    private List<Topic> topics;

    public Course() {
    }

    public Course( Integer id )
    {
        super( id );
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
                ", name='" + name;
    }
}
