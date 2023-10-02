package com.altun.courseerp.exception;

import com.altun.courseerp.models.BaseResponse;
import com.altun.courseerp.models.enums.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<?>> handleBaseException(BaseException ex){
        return ResponseEntity.status(ex.getResponseMessage().status()).body(BaseResponse.error(ex));
    }

}
