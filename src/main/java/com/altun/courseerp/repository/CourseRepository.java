package com.altun.courseerp.repository;

import com.altun.courseerp.models.mybatis.course.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseRepository {

    void insert(Course course);

}
