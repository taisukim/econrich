package com.example.econrich.dto.response.department;

import com.example.econrich.domain.Department;
import lombok.Data;

@Data
public class DepartmentInfoRes {

    private Long departmentId;
    private String departmentName;

    public DepartmentInfoRes(Department department) {
        this.departmentId = department.getId();
        this.departmentName = department.getName();
    }
}
