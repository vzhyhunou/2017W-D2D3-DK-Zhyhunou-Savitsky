package org.jmp17.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Entity
@Table(name = "LANGCOURSE")
public class LangCourse extends Course{
    private String language;
    private double price;

    public LangCourse() {
    }

    public LangCourse( Integer id )
    {
        super( id );
    }

    public LangCourse(Integer id, String name, String language) {
        super(id, name);
        this.language = language;
    }

    public LangCourse(Integer id, String name, String language, double price) {
        super(id, name);
        this.language = language;
        this.price = price;
    }

    public LangCourse(String name, String language) {
        super(name);
        this.language = language;
    }

    public LangCourse(String name, List<Topic> topics, String language) {
        super(name, topics);
        this.language = language;
    }

    public LangCourse(String name, List<Topic> topics, String language, double price) {
        super(name, topics);
        this.language = language;
        this.price = price;
    }

    public LangCourse(Integer id,String name, List<Topic> topics, String language) {
        super(id, name, topics);
        this.language = language;
    }

    public LangCourse(Integer id,String name, List<Topic> topics, String language, double price) {
        super(id, name, topics);
        this.language = language;
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LangCourse {" +
                super.toString() +
                ", language='" + language + '\'' +
                ", price=" + price + '\'' +
                '}';
    }
}
