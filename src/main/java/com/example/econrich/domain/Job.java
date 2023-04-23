package com.example.econrich.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "jobs")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Job {

    @Id
    @Column(name = "job_id", length = 10, nullable = false)
    private String id;

    @Column(name = "job_title", length = 35, nullable = false)
    private String title;

    @Column(precision = 8, scale = 0)
    private BigDecimal minSalary;

    @Column(precision = 8, scale = 0)
    private BigDecimal maxSalary;
}
