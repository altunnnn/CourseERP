package com.altun.courseerp.models.mybatis.course;

import com.altun.courseerp.models.enums.course.CourseStatus;
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
public class Course extends BaseEntity {

    String name;
    CourseStatus status;

}
