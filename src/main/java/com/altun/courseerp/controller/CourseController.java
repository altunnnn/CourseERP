package com.altun.courseerp.controller;

import com.altun.courseerp.models.BaseResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/test")
    public BaseResponse<String> test(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return BaseResponse.succed(userDetails.getUsername());
    }

    @GetMapping("/test/no-auth")
    public BaseResponse<String> testNoAuth() {
        return BaseResponse.succed("Course ERP - No Auth");
    }


}
