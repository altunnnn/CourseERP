package com.altun.courseerp.exception.types;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotFoundException {
    String target;
    Map<String,Object> fields;


    public static NotFoundException of(String target,Map<String,Object> fields){
        return NotFoundException.builder()
                .target(target)
                .fields(fields)
                .build();
    }
}
