package aston.serialization.task;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Insert filename for serialization object");
            String filename = scanner.nextLine();
            Person originPerson = new Person(33, "Anton", 1);
            File file = new File(filename);
            System.out.println("Object before serialization: " + originPerson);
            Serializer.serializeObject(file, originPerson);
            Person deserializedPerson = Deserializer.deserializeObject(new File(filename));
            System.out.println("Object after deserialization:" + deserializedPerson);
            if (originPerson.equals(deserializedPerson)) {
                System.out.println("Equality check: Origin object and deserialized object are equal!");
            } else {
                System.out.println("Equality check: Origin object and deserialized object not equal!");
            }
        }
    }
}

