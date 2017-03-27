package org.jmp17.decorator;

import java.io.IOException;

/**
 * Created by antonsavitsky on 3/12/17.
 */
public class PersonNameLowercaseInputStream extends PersonInputStream {
    private PersonInputStream personInputStream;

    public PersonNameLowercaseInputStream(PersonInputStream personInputStream) {
        super(personInputStream);
        this.personInputStream = personInputStream;
    }

    @Override
    public Person readPerson() throws IOException {
        Person person = personInputStream.readPerson();
        String name = person.getName();
        person.setName( Character.toLowerCase(name.charAt(0)) + name.substring(1) );
        return person;
    }
}
