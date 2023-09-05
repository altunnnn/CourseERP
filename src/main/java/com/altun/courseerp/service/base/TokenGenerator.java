package com.altun.courseerp.service.base;

public interface TokenGenerator <T>{

    String generate(T obj);

}
