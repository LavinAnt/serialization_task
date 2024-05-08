package aston.serialization.task;

import java.io.IOException;

public class SerializationException extends IOException {
    public SerializationException(String message) {
        super(message);
    }
}
