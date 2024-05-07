package aston.serialization.task;

import aston.serialization.task.Person;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Deserializer {
    public Person deserializeObject(String filename) {
        Person person = new Person();
        File file = new File(filename);
        if (!file.exists()) {
            throw new IllegalArgumentException("File" + filename + "does not exist");
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            person = (Person) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file" + filename + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found during deserialization: " + e.getMessage());
        }
        return person;
    }
}

