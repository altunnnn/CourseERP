package com.altun.courseerp.models.mybatis.user;

import com.altun.courseerp.models.enums.UserStatus;
import com.altun.courseerp.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {

    String name;
    String surname;
    UserStatus status;
    Long roleId;
    String phoneNumber;
    String email;
    String password;

}
