package aston.serialization.task;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void serializeObject(String filename, Person person) throws FileNotFoundException {
        File outputFile = new File(filename);
        if (outputFile.exists()) {
            throw new IllegalArgumentException("File exists");
        }
        if (person == null) {
            throw new IllegalArgumentException("Person object cannot be null");
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(outputFile, person);
            System.out.println("Object serialized into file: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Person deserializeObject(File outputFile) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        try {
            person = mapper.readValue(outputFile, Person.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert filename for serialization object");
        String filename = scanner.nextLine();
        Person originPerson = new Person(33, "Anton", 1);
        System.out.println("Object before serialization: " + originPerson);
        serializeObject(filename, originPerson);
        Person deserializedPerson = deserializeObject(new File(filename));
        System.out.println("Object after deserialization:" + deserializedPerson);
        if (originPerson.equals(deserializedPerson)) {
            System.out.println("Equality check: Origin object and deserialized object are equal!");
        } else {
            System.out.println("Equality check: Origin object and deserialized object not equal!");
        }
    }
}

