package org.jmp17.decorator;

import java.io.IOException;

/**
 * Created by asavitsky on 3/10/17.
 */
public class PersonNameCapitalizerOutputStream extends PersonOutputStream{
    private PersonOutputStream personOutputStream;

    public PersonNameCapitalizerOutputStream(PersonOutputStream personOutputStream) {
        super(personOutputStream);
        this.personOutputStream = personOutputStream;
    }

    @Override
    public void writePerson(Person person) throws IOException {
        String name =  person.getName();
        person.setName( Character.toUpperCase(name.charAt(0)) + name.substring(1) );
        personOutputStream.writePerson(person);
    }
}
