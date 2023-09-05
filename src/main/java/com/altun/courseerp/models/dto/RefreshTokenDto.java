package com.altun.courseerp.models.dto;

import com.altun.courseerp.models.mybatis.user.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RefreshTokenDto {
    boolean rememberMe;
    User user;
}
