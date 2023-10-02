package com.altun.courseerp.models.mybatis.role;

import com.altun.courseerp.models.mybatis.base.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
// SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends BaseEntity {
    String name;
    String description;
}
