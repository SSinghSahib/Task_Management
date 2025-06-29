package com.sikhimarg.taskmanagement.exception;

/** Wird geworfen, wenn eine angeforderte Ressource
 * (z.B. Benutzer, Task) nicht gefunden wurde.**/

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }
}
