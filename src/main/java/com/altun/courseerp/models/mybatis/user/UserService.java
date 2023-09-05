package com.altun.courseerp.models.mybatis.user;

public interface UserService {
    void insert(User user);
    User getEmail(String email);
}
