package br.com.beachtennisbrazil.api.system.exceptions;

import io.swagger.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class SystemGlobalExceptionHandler {

    @ExceptionHandler(LoginUsernameOrPasswordIsInvalidException.class)
    public ResponseEntity<StandardResponseError> standardErrorLoginUsernameOrPasswordIsInvalidException(LoginUsernameOrPasswordIsInvalidException exception, HttpServletRequest request) {
        String error = "Invalid login or username exception!";
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
