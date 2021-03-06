package com.k12.exceptions;

public class SaveException extends RuntimeException {

    public SaveException() {

    }

    public SaveException(final String message) {
        super(message);
    }

    public SaveException(final Throwable cause) {
        super(cause);
    }

    public SaveException(final String message, final Throwable cause) {
        super(message, cause);
    }
}