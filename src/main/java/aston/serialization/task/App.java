package aston.serialization.task;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.util.Objects;
import java.util.Scanner;
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert filename for serialization object");
        String filename = scanner.nextLine();
        Person originPerson = new Person(33, "Anton", 1);

        System.out.println("Object before serialization: "+ originPerson);
        Serializer serializer = new Serializer();
        serializer.serializeObject(filename, originPerson);
        Deserializer deserializer = new Deserializer();
        Person deserializedPerson = deserializer.deserializeObject(filename);
        System.out.println("Object after deserialization: "+ deserializedPerson);
        if (originPerson.equals(deserializedPerson))
        {
            System.out.println("Equality check: Origin object and deserialized object are equal!");
        }
        else {
            System.out.println("Equality check: Origin object and deserialized object not equal!");
        }
    }
}

