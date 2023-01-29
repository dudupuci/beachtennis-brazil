package br.com.beachtennisbrazil.api.app.exceptions.handlers;


import br.com.beachtennisbrazil.api.app.exceptions.CannotCreateGameCourtException;
import br.com.beachtennisbrazil.api.app.exceptions.StandardResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class GameCourtExceptionHandler {

    @ExceptionHandler(CannotCreateGameCourtException.class)
    public ResponseEntity<StandardResponseError> standardError(CannotCreateGameCourtException exception, HttpServletRequest request) {
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


}
