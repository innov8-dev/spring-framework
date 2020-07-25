package dev.innov8.devboards.exceptions;

public class DevboardsException extends RuntimeException {

    private int status;

    public DevboardsException(int status) {
        this.status = status;
    }

    public DevboardsException(int status, Throwable cause) {
        super(cause);
        this.status = status;
    }

    public DevboardsException(int status, String msg) {
        super(msg);
        this.status = status;
    }

    public DevboardsException(int status, String msg, Throwable cause) {
        super(msg, cause);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
