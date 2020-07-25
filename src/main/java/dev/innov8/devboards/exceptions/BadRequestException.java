package dev.innov8.devboards.exceptions;

public class BadRequestException extends DevboardsException {

    public BadRequestException() {
        super(400, "Invalid request made!");
    }

    public BadRequestException(String msg) {
        super(400, msg);
    }

    public BadRequestException(String msg, Throwable cause) {
        super(400, msg, cause);
    }

}
