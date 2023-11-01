package com.altun.courseerp.repository;

import com.altun.courseerp.models.mybatis.employee.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    void insert(Employee employee);
}
