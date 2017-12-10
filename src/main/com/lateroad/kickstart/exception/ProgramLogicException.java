package com.lateroad.kickstart.exception;

public class ProgramLogicException extends Exception {
    public ProgramLogicException() {
        super();
    }

    public ProgramLogicException(String message) {
        super(message);
    }

    public ProgramLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProgramLogicException(Throwable cause) {
        super(cause);
    }
}
