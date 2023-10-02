package com.altun.courseerp.payload.auth;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpPayload {
    String name;
    String surname;
    String email;
    String password;
    String phoneNumber;

    String courseName;
    String address;
}
