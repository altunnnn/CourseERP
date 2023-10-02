package com.altun.courseerp.models.enums.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum SuccessResponseMessage implements ResponseMessage{
    SUCCESS_RESPONSE_MESSAGE("success", "Successfully", HttpStatus.OK);


    String key;
    String message;
    HttpStatus status;


    @Override
    public String key() {
        return null;
    }

    @Override
    public String message() {
        return null;
    }

    @Override
    public HttpStatus status() {
        return null;
    }
}
