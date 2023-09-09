package com.altun.courseerp.controller;

import com.altun.courseerp.models.BaseResponse;
import com.altun.courseerp.models.dto.RefreshTokenDto;
import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.models.response.auth.LoginResponse;
import com.altun.courseerp.payload.auth.LoginPayload;
import com.altun.courseerp.payload.auth.RefreshPayload;
import com.altun.courseerp.service.security.AccesTokenManager;
import com.altun.courseerp.service.security.AuthBusinessService;
import com.altun.courseerp.service.security.AuthBusinessServiceImp;
import com.altun.courseerp.service.security.RefreshTokenManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthBusinessService authBusinessService;

    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginPayload loginPayload){
        return BaseResponse.succed(
                authBusinessService.login(loginPayload)
        );
    }

    @PostMapping("/token/refresh")
    public BaseResponse<LoginResponse> refresh(@RequestBody RefreshPayload refreshPayload){

        return BaseResponse.succed(authBusinessService.refresh(refreshPayload));
    }

    @PostMapping("/logout")
    public BaseResponse<Void> logout(){
        authBusinessService.logout();
        return BaseResponse.succed();
    }




}
