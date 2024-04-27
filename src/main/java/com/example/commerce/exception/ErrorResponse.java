package com.example.commerce.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@RequiredArgsConstructor
public class ErrorResponse {
    private final HttpStatus status;
    private final String customCode;
    private final String message;

    public static ResponseEntity<ErrorResponse> responseError(CustomException e) {
        return ResponseEntity
                .status(e.getCustomCode().getStatus())
                .body(ErrorResponse.builder()
                        .status(e.getCustomCode().getStatus())
                        .customCode(e.getCustomCode().name())
                        .message(e.getCustomCode().getMessage())
                        .build());
    }
}
