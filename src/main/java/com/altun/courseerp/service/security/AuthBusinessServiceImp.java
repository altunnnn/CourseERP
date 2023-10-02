package com.altun.courseerp.service.security;

import com.altun.courseerp.exception.BaseException;
import com.altun.courseerp.mappers.CourseEntityMapper;
import com.altun.courseerp.mappers.UserEntityMapper;
import com.altun.courseerp.models.BaseResponse;
import com.altun.courseerp.models.dto.RefreshTokenDto;
import com.altun.courseerp.models.mybatis.course.Course;
import com.altun.courseerp.models.mybatis.role.Role;
import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.models.mybatis.user.UserService;
import com.altun.courseerp.models.response.auth.LoginResponse;
import com.altun.courseerp.payload.auth.LoginPayload;
import com.altun.courseerp.payload.auth.RefreshPayload;
import com.altun.courseerp.payload.auth.SignUpPayload;
import com.altun.courseerp.service.course.CourseService;
import com.altun.courseerp.service.role.RoleService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.altun.courseerp.models.enums.response.ErrorResponseMessages.EMAIL_ALREADY_REGISTERED;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthBusinessServiceImp implements AuthBusinessService{
    private final AccesTokenManager accesTokenManager;
    private final RefreshTokenManager refreshTokenManager;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final CourseService courseService;

    @Override
    public LoginResponse login(LoginPayload loginPayload) {
        authenticate(loginPayload);

        return prepareLoginResponse(loginPayload.getEmail(), loginPayload.isRememberMe());
    }
    @Override
    public LoginResponse refresh(RefreshPayload payload){
        return prepareLoginResponse(
                refreshTokenManager.getEmail(payload.getRefreshToken()),
                payload.isRememberMe());
    }

    @Override
    public void logout() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("{} user logout " + userDetails.getUsername());
    }

    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities())
        );
    }



    @Override
    public void signup(SignUpPayload signUpPayload) {
        if (userService.checkByEmail(signUpPayload.getEmail())) {
            throw BaseException.of(EMAIL_ALREADY_REGISTERED);
        }
        Role defaultRole = roleService.defaultRole();

        User user = UserEntityMapper.INSTANCE.fromSignUpPayloadToUser(
                signUpPayload,
                passwordEncoder.encode(signUpPayload.getPassword()),
                defaultRole.getId()
        );
        userService.insert(user);

        Course course = CourseEntityMapper.INSTANCE.fromSignUpPayload(signUpPayload);
        courseService.insert(course);
    }

    private void authenticate(LoginPayload request){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword())
            );
        }catch (AuthenticationException e){
            throw new RuntimeException("Exception: " + e);
        }
    }

    private LoginResponse prepareLoginResponse(String email, boolean rememberMe) {
        User user = userService.getEmail(email);

        return LoginResponse.builder()
                .accessToken(accesTokenManager.generate(user))
                .refreshToken(refreshTokenManager.generate(
                        RefreshTokenDto.builder()
                                .user(user)
                                .rememberMe(rememberMe)
                                .build()
                ))
                .build();
    }
}
