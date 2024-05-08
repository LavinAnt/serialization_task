package aston.serialization.task;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Deserializer {
    public static Person deserializeObject(File file) throws SerializationException {
        if (!file.exists()) {
            throw new SerializationException("File exists");
        }
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        try {
            person = mapper.readValue(file, Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
