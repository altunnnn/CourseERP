package com.altun.courseerp.models.enums.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public  enum  ErrorResponseMessages implements ResponseMessage {
    UNEXPECTED("unexpected", "Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_FOUND("not_found_%s","%s_cant_find_%s",HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_REGISTERED("email_already_registered","Email already registered",HttpStatus.CONFLICT)
    ;


    String key;
    String message;
    HttpStatus status;

    @Override
    public String key() {
        return key;
    }

    @Override
    public String message() {
        return message;
    }

    @Override
    public HttpStatus status() {
        return status;
    }
}
