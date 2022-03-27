package com.antnest.handler;

public class AntnestException extends RuntimeException {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AntnestException() {
        super();
    }

    public AntnestException(String message) {
        super(message);
    }

    public AntnestException(String message, int code) {
        super(message);
        this.code = code;
    }

    public AntnestException(String message, Throwable cause) {
        super(message, cause);
    }

    public AntnestException(Throwable cause) {
        super(cause);
    }

    protected AntnestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
