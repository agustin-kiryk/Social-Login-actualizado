package com.example.google.dto;

public class BadRequestResult extends ResultDTO {
    public BadRequestResult() {
        super("JSON deserialization failed");
    }
}
