package com.altun.courseerp.service.branch;

import com.altun.courseerp.models.mybatis.branch.Branch;
import com.altun.courseerp.repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService{
    private final BranchRepository branchRepository;

    @Override
    public void insert(Branch branch) {
        branchRepository.insert(branch);
    }
}
