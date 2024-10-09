package net.ottleys.carwars.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;

    @JsonPropertyOrder({"timestamp", "status", "error"})
    public ErrorResponse(int status, String error) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
    }

    public int getStatusCode() {
        return status;
    }

    public String getError() {
        return error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

}
