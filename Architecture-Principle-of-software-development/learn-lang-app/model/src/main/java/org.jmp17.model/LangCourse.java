package org.jmp17.model;

import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
public class LangCourse extends Course{
    private String language;

    public LangCourse() {
    }

    public LangCourse(Integer id, String name, String language) {
        super(id, name);
        this.language = language;
    }

    public LangCourse(String name, String language) {
        super(name);
        this.language = language;
    }

    public LangCourse(String name, List<Topic> topics, String language) {
        super(name, topics);
        this.language = language;
    }

    public LangCourse(Integer id,String name, List<Topic> topics, String language) {
        super(id, name, topics);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "LangCourse {" +
                super.toString() +
                ", language='" + language + '\'' +
                '}';
    }
}
