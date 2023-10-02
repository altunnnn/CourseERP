package com.altun.courseerp.mappers;

import com.altun.courseerp.models.mybatis.course.Course;
import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.payload.auth.SignUpPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseEntityMapper {

    CourseEntityMapper INSTANCE = Mappers.getMapper(CourseEntityMapper.class);


    @Mapping(target = "name", source = "courseName")
    @Mapping(target = "status", constant = "ACTIVE")
    Course fromSignUpPayload(SignUpPayload signUpPayload);
}
