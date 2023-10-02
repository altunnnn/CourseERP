package com.altun.courseerp.exception;

import com.altun.courseerp.exception.types.NotFoundException;
import com.altun.courseerp.models.enums.response.ErrorResponseMessages;
import com.altun.courseerp.models.enums.response.ResponseMessage;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

import static com.altun.courseerp.models.enums.response.ErrorResponseMessages.UNEXPECTED;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseException extends RuntimeException {

    ResponseMessage responseMessage;
    NotFoundException notFoundException;


    @Override
    public String getMessage() {
        return responseMessage.message();
    }

    public static BaseException of(ResponseMessage responseMessage){
        return BaseException.builder().responseMessage(responseMessage).build();
    }

    public static BaseException unexpected(){
        return of(UNEXPECTED);
    }

    public static BaseException notFound(String target, String field, String value){
        return BaseException.builder()
                .responseMessage(ErrorResponseMessages.NOT_FOUND)
                .notFoundException(
                        NotFoundException.of(target, Map.of(field,value))
                )
                .build();
    }

}
