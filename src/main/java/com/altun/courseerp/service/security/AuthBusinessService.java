package com.altun.courseerp.service.security;

import com.altun.courseerp.models.response.auth.LoginResponse;
import com.altun.courseerp.payload.auth.LoginPayload;
import com.altun.courseerp.payload.auth.RefreshPayload;
import com.altun.courseerp.payload.auth.SignUpPayload;
import com.altun.courseerp.payload.auth.otp.BaseOTPChannelRequest;

public interface AuthBusinessService {
    LoginResponse login(LoginPayload loginPayload);
     LoginResponse refresh(RefreshPayload payload);
     void logout();
    void setAuthentication(String email);
    void signup(SignUpPayload signUpPayload);

    void signupOtp(BaseOTPChannelRequest baseOTPChannelRequest);
    void signupOTPconfirmation();
}
