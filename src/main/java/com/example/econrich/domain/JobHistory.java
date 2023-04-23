package com.example.econrich.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@IdClass(JobHistoryId.class)
public class JobHistory {

    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employeeId;

    @Id
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
