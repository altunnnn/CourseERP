package com.altun.courseerp.models;


import com.altun.courseerp.exception.BaseException;
import com.altun.courseerp.exception.types.NotFoundException;
import com.altun.courseerp.models.enums.response.ErrorResponseMessages;
import com.altun.courseerp.models.enums.response.ResponseMessage;
import com.altun.courseerp.models.enums.response.SuccessResponseMessage;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL) // request zamani null olan fieldleri gostermir
public class BaseResponse<T> {
    HttpStatus status;
    Meta meta;
    T data;

    @Data
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder(access = AccessLevel.PRIVATE)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static final class Meta{

        String message;
        String key;


        public static Meta of(String message,String key){
            return Meta.builder()
                    .message(message)
                    .key(key)
                    .build();
        }
        public static Meta of(ResponseMessage responseMessage){
            return of(responseMessage.message(), responseMessage.key());
        }
        public static Meta of(BaseException ex){

            NotFoundException notFoundException = ex.getNotFoundException();

            if (ex.getResponseMessage() == ErrorResponseMessages.NOT_FOUND){
                return of(
                        String.format(ex.getResponseMessage().key(), notFoundException.getTarget().toLowerCase()),
                        String.format(ex.getResponseMessage().message(),notFoundException.getTarget(),notFoundException.getFields().toString())
                );
            }
            return of(ex.getResponseMessage());
        }
    }

    public static <T>BaseResponse<T> succed(T data){
        return BaseResponse.<T>builder().
                status(HttpStatus.OK).
                meta(Meta.of(SuccessResponseMessage.SUCCESS_RESPONSE_MESSAGE)).
                data(data).
                build();
    }

    public static <T> BaseResponse<T> succed() {
        return succed(null);
    }

    public static BaseResponse<?> error(BaseException ex){
        return BaseResponse.builder()
                .meta(Meta.of(ex))
                .status(ex.getResponseMessage().status())
                .build();
    }
}
