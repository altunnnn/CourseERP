package com.altun.courseerp.models.mybatis.branch;

import com.altun.courseerp.models.enums.branch.BranchStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
// SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Branch {
    String name;
    String address;
    BranchStatus status;
    Double lat;
    Double lon;
    Long courseId;
}
