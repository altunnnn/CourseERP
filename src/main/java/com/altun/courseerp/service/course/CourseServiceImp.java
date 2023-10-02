package com.altun.courseerp.service.course;

import com.altun.courseerp.models.mybatis.course.Course;
import com.altun.courseerp.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImp implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public void insert(Course course) {
        courseRepository.insert(course);
    }
}
