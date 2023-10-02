package com.altun.courseerp.models.enums.response;

import org.springframework.http.HttpStatus;

public interface ResponseMessage {
    String key();
    String message();
    HttpStatus status();
}
