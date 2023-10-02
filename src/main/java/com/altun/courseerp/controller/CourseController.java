package com.altun.courseerp.controller;

import com.altun.courseerp.exception.BaseException;
import com.altun.courseerp.models.BaseResponse;
import com.altun.courseerp.models.mybatis.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public BaseResponse<String> test(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return BaseResponse.succed(userDetails.getUsername());
    }

    @GetMapping("/test/no-auth")
    public BaseResponse<String> testNoAuth() {
      //  throw BaseException.unexpected();
        userService.getEmail("asdadad");
        return BaseResponse.succed("Course ERP - No Auth");
    }


}
