package com.altun.courseerp.service.role;

import com.altun.courseerp.exception.BaseException;
import com.altun.courseerp.models.mybatis.role.Role;
import com.altun.courseerp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private static final String OWNER = "OWNER";

    @Override
    public Role defaultRole() {
        return roleRepository.findByUsername(OWNER).orElseThrow(
                BaseException::unexpected
        );
    }
}
