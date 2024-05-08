package aston.serialization.task.exeptions;

import java.io.Serial;

public class SerializationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 7326913820961085637L;

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }
}
