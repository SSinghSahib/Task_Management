package com.sikhimarg.taskmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /* Behandelt alle NotFoundExceptions (404 Fehler) */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("zeitpunkt", LocalDateTime.now());
        body.put("fehler", "Nicht gefunden");
        body.put("nachricht", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    /**
     * Behandelt allgemeine Validierungsfehler (z. B. @Valid verletzt)
     */
    @ExceptionHandler(org.springframework.web.bind.MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("zeitpunkt", LocalDateTime.now());
        body.put("fehler", "Ungültige Eingabe");
        body.put("nachricht", "Bitte Eingabedaten prüfen.");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    /**
     * Allgemeiner Fallback für alle anderen Fehler (500)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllOtherExceptions(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("zeitpunkt", LocalDateTime.now());
        body.put("fehler", "Interner Serverfehler");
        body.put("nachricht", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}