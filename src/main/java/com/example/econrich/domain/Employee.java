package com.example.econrich.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private Long id;

    @Column(length = 20)
    private String firstName;
    @Column(length = 25, nullable = false)
    private String lastName;
    @Column(length = 25, nullable = false)
    private String email;
    @Column(length = 20)
    private String phoneNumber;
    @Column(nullable = false)
    private LocalDateTime hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", referencedColumnName = "job_id", nullable = false)
    private Job job;

    @Column(precision = 8, scale = 2, nullable = false)
    private BigDecimal salary;
    @Column(precision = 2, scale = 2)
    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "employee_id")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Department department;


    protected void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
