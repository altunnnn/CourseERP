package com.altun.courseerp.repository;

import com.altun.courseerp.models.mybatis.branch.Branch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BranchRepository {

    void insert(Branch branch);

}
