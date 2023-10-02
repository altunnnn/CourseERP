package com.altun.courseerp.models.mybatis.user;

import com.altun.courseerp.exception.BaseException;
import com.altun.courseerp.payload.auth.SignUpPayload;
import com.altun.courseerp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public User getEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                //todo : create exception model
                () -> BaseException.notFound(User.class.getSimpleName(), "email",email)
            //    () -> new RuntimeException("User not found")
        );
    }

    @Override
    public boolean checkByEmail(String email) {
        boolean present = userRepository.findByEmail(email).isPresent();
        return present;
    }
}
