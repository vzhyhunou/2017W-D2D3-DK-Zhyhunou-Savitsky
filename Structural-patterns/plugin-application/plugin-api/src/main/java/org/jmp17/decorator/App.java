package org.jmp17.decorator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by antonsavitsky on 3/12/17.
 */
public class App {
    public static void main(String[] args) throws IOException {
        Person person = new Person("ivan Ivanov");
        String fileName = generateFileName(person);
        PersonOutputStream personNameCapitalizerOutputStream =
                new PersonNameCapitalizerOutputStream(
                        new PersonOutputStream(
                                new FileOutputStream(fileName)
                        )
                );
        personNameCapitalizerOutputStream.writePerson(person);

        PersonInputStream personNameLowercaseInputStream =
                new PersonNameLowercaseInputStream(
                        new PersonInputStream(
                                new FileInputStream(fileName)
                        )
                );
        System.out.println( personNameLowercaseInputStream.readPerson() );

    }

    public static String generateFileName(Person person){
        return person.getName();
    }
}
