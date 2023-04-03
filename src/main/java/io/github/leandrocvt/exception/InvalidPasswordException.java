package io.github.leandrocvt.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException() {
        super("Invalid Password!");
    }
}
