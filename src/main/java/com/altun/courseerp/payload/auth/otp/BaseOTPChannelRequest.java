package com.altun.courseerp.payload.auth.otp;

import com.altun.courseerp.models.enums.otp.OTPChannel;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseOTPChannelRequest {
    private OTPChannel channel;
}
