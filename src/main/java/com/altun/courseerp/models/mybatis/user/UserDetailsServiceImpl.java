package com.altun.courseerp.models.mybatis.user;

import com.altun.courseerp.exception.BaseException;
import com.altun.courseerp.models.enums.response.ErrorResponseMessages;
import com.altun.courseerp.models.security.LoggedInUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.getEmail(username);

        if (!user.isActive()){
            throw BaseException.of(ErrorResponseMessages.USER_IS_NOT_ACTIVE);
        }

        return new LoggedInUserDetails(
                user.getName(),
                user.getPassword(),
                new ArrayList<>()
        );
    }
}
