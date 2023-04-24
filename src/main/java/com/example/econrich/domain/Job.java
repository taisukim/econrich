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


    /**
     * maxSalary 의 기준이 employee 의 값에의해 변경될때 같이 수정해주어야하므로
     * 메서드를 만들어서 job 의 maxSalary 가 해당 employee 의 인상된 급여보다 작을경우 데이터를 업데이트한다
     * @param maxSalary
     */
    protected void maxSalaryCheck(BigDecimal maxSalary) {
        int compareResult = this.maxSalary.compareTo(maxSalary);
        if(compareResult < 0 ){
            this.maxSalary = maxSalary;
        }
    }
}
