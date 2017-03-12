package org.jmp17.decorator;

import org.springframework.util.SerializationUtils;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;

/**
 * Created by asavitsky on 3/10/17.
 */
public class PersonOutputStream extends OutputStream {
    private OutputStream outputStream;

    public PersonOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }
    public void writePerson(Person person) throws IOException {
        byte[] data = SerializationUtils.serialize(person);
        outputStream.write(data);
    }
}
