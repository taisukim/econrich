package com.example.econrich.dto.response.job;

import com.example.econrich.domain.Job;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class JobInfoRes {

    private String jobId;
    private BigDecimal minSalary;
    private BigDecimal maxSalary;
    private String jobTitle;

    public JobInfoRes(Job job){
        this.jobId = job.getId();
        this.minSalary = job.getMinSalary();
        this.maxSalary = job.getMaxSalary();
        this.jobTitle = job.getTitle();
    }
}
