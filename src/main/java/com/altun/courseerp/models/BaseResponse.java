package com.altun.courseerp.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse<T> {
    HttpStatus status;
    String msg;
    T data;

    public static <T>BaseResponse<T> succed(T data){
        return BaseResponse.<T>builder().
                status(HttpStatus.OK).
                msg("succed").
                data(data).
                build();
    }

    public static <T> BaseResponse<T> succed() {
        return succed(null);
    }
}
