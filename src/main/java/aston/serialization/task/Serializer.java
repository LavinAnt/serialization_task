package aston.serialization.task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {
    public void serializeObject(String filename, Person person) throws FileNotFoundException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename is empty");
        }
        if (person == null) {
            throw new IllegalArgumentException("Person object cannot be null");
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(person);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing object to file" + filename + e.getMessage());
        }
    }
}
