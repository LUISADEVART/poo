package com.example.tutoria01.exceptions;

public class ErrorRespuesta {

    private final String error;

    public ErrorRespuesta(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }

}
