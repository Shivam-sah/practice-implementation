package com.practise.project.exception;

import com.practise.project.builder.ResponseMessage;

import lombok.Data;

@Data
public class BadApiRequestException extends RuntimeException {
    private final ResponseMessage responseMessage;

    public BadApiRequestException() {
        super("Bad Request");
        this.responseMessage = null;
    }

    public BadApiRequestException(String message) {
        super(message);
        this.responseMessage = null;
    }

    public BadApiRequestException(String message, ResponseMessage responseMessage) {
        super(message);
        this.responseMessage = responseMessage;
    }

    public BadApiRequestException(String message, Throwable cause) {
        super(message, cause);
        this.responseMessage = null;
    }

    public BadApiRequestException(String message, ResponseMessage responseMessage, Throwable cause) {
        super(message, cause);
        this.responseMessage = responseMessage;
    }

    public BadApiRequestException(Throwable cause) {
        super(cause);
        this.responseMessage = null;
    }

}
