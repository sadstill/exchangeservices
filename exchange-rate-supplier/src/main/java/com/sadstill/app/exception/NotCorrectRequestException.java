package com.sadstill.app.exception;

public class NotCorrectRequestException extends RuntimeException {

    public NotCorrectRequestException() {
        super();
    }

    public NotCorrectRequestException(String message) {
        super(message);
    }

    public NotCorrectRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCorrectRequestException(Throwable cause) {
        super(cause);
    }

    public NotCorrectRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

