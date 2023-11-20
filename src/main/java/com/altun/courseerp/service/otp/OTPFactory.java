package com.altun.courseerp.service.otp;

import com.altun.courseerp.models.enums.otp.OTPChannel;
import org.springframework.stereotype.Service;

@Service
public class OTPFactory {

    private static EmailOTPServiceImpl emailOTPService;
    private static SMSOTPServiceImpl smsotpService;

    public OTPFactory(EmailOTPServiceImpl emailOTPService, SMSOTPServiceImpl smsotpService){
        OTPFactory.emailOTPService = emailOTPService;
        OTPFactory.smsotpService = smsotpService;
    }

    public OTPService handle(OTPChannel otpChannel){
        return switch (otpChannel){
            case SMS -> smsotpService;
            case EMAIL -> emailOTPService;
        };
    }
}
