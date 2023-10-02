package com.altun.courseerp.models.mybatis.user;

import com.altun.courseerp.payload.auth.SignUpPayload;

public interface UserService {
    void insert(User user);
    User getEmail(String email);
    boolean checkByEmail(String email);
}
