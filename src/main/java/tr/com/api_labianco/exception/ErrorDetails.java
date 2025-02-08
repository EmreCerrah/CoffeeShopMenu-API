package tr.com.api_labianco.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;
    private final int status;

    public ErrorDetails(String message, String details, int status) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
        this.status = status;
    }
}