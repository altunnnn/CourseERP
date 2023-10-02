package com.altun.courseerp.repository;

import com.altun.courseerp.models.mybatis.role.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface RoleRepository {

    Optional<Role> findByUsername(@Param("name") String name);


}
