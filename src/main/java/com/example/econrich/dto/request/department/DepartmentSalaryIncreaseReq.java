package com.example.econrich.dto.request.department;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class DepartmentSalaryIncreaseReq {

    @Min(1)
    private Double percent;
}
