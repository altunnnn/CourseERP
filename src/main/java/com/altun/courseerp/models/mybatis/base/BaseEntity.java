package com.altun.courseerp.models.mybatis.base;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity extends IsDeletedEntity{

    Long id;

}
