package com.altun.courseerp.service.otp;

import com.altun.courseerp.models.mybatis.user.User;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OtpServiceImpl implements OtpService {

    @Override
    public void send(){
        System.out.printf("OTP send: %s%n", UUID.randomUUID().toString().substring(0,4));
    }

}
