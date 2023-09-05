package com.altun.courseerp.controller;

import com.altun.courseerp.models.BaseResponse;
import com.altun.courseerp.models.dto.RefreshTokenDto;
import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.models.response.auth.LoginResponse;
import com.altun.courseerp.payload.auth.LoginPayload;
import com.altun.courseerp.service.security.AccesTokenManager;
import com.altun.courseerp.service.security.RefreshTokenManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AccesTokenManager accesTokenManager;
    private final RefreshTokenManager refreshTokenManager;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload loginPayload){
        User user = User.builder().email("altun@gmail.com").build();
        user.setId(1L);


        return BaseResponse.succed(
                LoginResponse.builder()
                        .accessToken(accesTokenManager.generate(user))
                        .refreshToken(refreshTokenManager.generate(RefreshTokenDto.builder()
                                        .rememberMe(loginPayload.isRememberMe())
                                        .user(user)
                                .build()))
                        .build()
        );
    }

}
