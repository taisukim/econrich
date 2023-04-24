package com.example.econrich.dto.response.employee;

import com.example.econrich.domain.JobHistory;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class GetEmployeeHistoryInfoRes {
    private Long employeeId;
    private LocalDate startData;
    private LocalDate endDate;
    private Long departmentId;
    private String departmentName;
    private String jobId;
    private String jobTitle;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;

    public GetEmployeeHistoryInfoRes(JobHistory jobHistory) {
        this.employeeId = jobHistory.getEmployeeId().getId();
        this.startData = jobHistory.getStartDate();
        this.endDate = jobHistory.getEndDate();
        this.departmentId = jobHistory.getDepartment().getId();
        this.departmentName = jobHistory.getDepartment().getName();
        this.jobId = jobHistory.getJob().getId();
        this.jobTitle = jobHistory.getJob().getTitle();
        this.minSalary = jobHistory.getJob().getMinSalary();
        this.maxSalary = jobHistory.getJob().getMaxSalary();
    }
}
