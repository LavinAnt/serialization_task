package aston.serialization.task;

import aston.serialization.task.entity.Person;
import aston.serialization.task.utils.SerializeUtils;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Insert filename for serialization object");
            String filename = scanner.nextLine();
            Person originPerson = new Person(33, "Anton", 1);
            File file = new File(filename);
            System.out.println("Object before serialization: " + originPerson);
            SerializeUtils.serializeObject(file, originPerson);
            Person deserializedPerson = SerializeUtils.deserializeObject(new File(filename));
            System.out.println("Object after deserialization:" + deserializedPerson);
            if (originPerson.equals(deserializedPerson)) {
                System.out.println("Equality check: Origin object and deserialized object are equal!");
            } else {
                System.out.println("Equality check: Origin object and deserialized object not equal!");
            }
        }
    }
}

