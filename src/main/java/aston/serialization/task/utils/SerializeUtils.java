package aston.serialization.task.utils;

import aston.serialization.task.entity.Person;
import aston.serialization.task.exeptions.SerializationException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Utility class for serialization and deserialization object {@link Person}.
 */
public final class SerializeUtils {

    private SerializeUtils() {
    }

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
        } catch (Exception e) {
            throw new SerializationException(e);
        }

    }

    public static Person deserializeObject(File file) throws SerializationException {
        if (!file.exists()) {
            throw new SerializationException("File exists");
        }
        ObjectMapper mapper = new ObjectMapper();
        Person person;
        try {
            person = mapper.readValue(file, Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}

