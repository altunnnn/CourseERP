package com.altun.courseerp.filters;

import com.altun.courseerp.models.mybatis.user.User;
import com.altun.courseerp.models.mybatis.user.UserService;
import com.altun.courseerp.models.security.LoggedInUserDetails;
import com.altun.courseerp.service.security.AccesTokenManager;
import com.altun.courseerp.service.security.AuthBusinessService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

import static com.altun.courseerp.constrants.TokenConstrants.EMAIL;
import static com.altun.courseerp.constrants.TokenConstrants.PREFIX;


@Component
@RequiredArgsConstructor
public class AuthorationFilter extends OncePerRequestFilter {

    private final AccesTokenManager accesTokenManager;
    private final AuthBusinessService authBusinessService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.nonNull(token) && token.startsWith(PREFIX)){
            authBusinessService.setAuthentication(
                    accesTokenManager.getEmail(token.substring(7))
            );
        }

        filterChain.doFilter(request,response);
    }
}
