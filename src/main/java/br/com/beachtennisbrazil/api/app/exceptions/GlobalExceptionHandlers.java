package br.com.beachtennisbrazil.api.app.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(CannotCreateGameCourtException.class)
    public ResponseEntity<StandardResponseError> standardErrorCannotCreateGameCourtException(CannotCreateGameCourtException exception, HttpServletRequest request) {
        String error = "Cannot create game court!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardResponseError response = new StandardResponseError(
                Instant.now(),
                status.value(),
                error,
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardResponseError> standardErrorEntityNotFoundException(EntityNotFoundException exception, HttpServletRequest request) {
        String error = "Entity not found in database!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardResponseError response = new StandardResponseError(
                Instant.now(),
                status.value(),
                error,
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(response);
    }


}
