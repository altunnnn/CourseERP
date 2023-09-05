package com.altun.courseerp.repository;

import com.altun.courseerp.models.mybatis.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Optional;

@Mapper
public interface UserRepository {
    void insert(User user);

    Optional<User> findByEmail(@Param("email") String email);
}
