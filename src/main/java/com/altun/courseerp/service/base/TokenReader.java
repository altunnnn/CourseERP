package com.altun.courseerp.service.base;

public interface TokenReader<T>{

    T read(String token);

}
