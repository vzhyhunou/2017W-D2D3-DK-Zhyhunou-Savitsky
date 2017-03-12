package org.jmp17.decorator;

import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by antonsavitsky on 3/12/17.
 */
public class PersonInputStream extends InputStream{
    private InputStream inputStream;

    public PersonInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    public Person readPerson() throws IOException {
        byte[] data = new byte[200];
        inputStream.read(data);
        return (Person) SerializationUtils.deserialize(data);
    }
}
