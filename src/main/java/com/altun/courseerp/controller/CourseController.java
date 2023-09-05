package com.altun.courseerp.controller;

import com.altun.courseerp.models.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/test")
    public BaseResponse<String> test(){
        return BaseResponse.succed("Course ERP");
    }



}
