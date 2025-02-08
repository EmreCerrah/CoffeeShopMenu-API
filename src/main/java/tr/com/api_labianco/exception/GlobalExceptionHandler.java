package tr.com.api_labianco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Specific Exception Handlers
    @ExceptionHandler(ResourceNotFoundException_404.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException_404 ex, WebRequest request) {
        return new ResponseEntity<>(buildErrorDetails(ex, request, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    // General Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(buildErrorDetails(ex, request, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Helper Method
    private ErrorDetails buildErrorDetails(Exception ex, WebRequest request, HttpStatus status) {
        return new ErrorDetails (ex.getMessage(),request.getDescription(false),status.value());
    }
}