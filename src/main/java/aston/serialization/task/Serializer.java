package aston.serialization.task;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Serializer {
    public static void serializeObject(File outputFile, Person person) throws SerializationException {
        if (outputFile.exists()) {
            throw new SerializationException("File exists");
        }
        if (person == null) {
            throw new SerializationException("Person object cannot be null");
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(outputFile, person);
            System.out.println("Object serialized into file: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
