package com.captainparlik.exception.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class ErrorResponse {

    private Instant timestamp;
    private int status;
    private String error;
    private String path;
}
