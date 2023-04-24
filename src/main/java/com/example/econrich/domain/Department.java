package com.example.econrich.domain;

import com.example.econrich.dto.request.department.DepartmentSalaryIncreaseReq;
import com.example.econrich.dto.response.department.DepartmentSalaryIncreaseRes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "departments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "department_id", nullable = false, columnDefinition = "INT(11) UNSIGNED")
    private Long id;

    @Column(name = "department_name", nullable = false, length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
    private List<Employee> employee = new ArrayList<>();


    public List<DepartmentSalaryIncreaseRes> salaryIncrease(DepartmentSalaryIncreaseReq req){
        return this.getEmployee().stream().map(employee -> {
            DepartmentSalaryIncreaseRes departmentSalaryIncreaseRes = new DepartmentSalaryIncreaseRes(employee);
            //변경된 급여로 데이터 수정
            BigDecimal updateSalary = employee.getSalary().multiply(BigDecimal.valueOf(req.getPercent()));
            //변경된 급여가 해당 직책? 의 최대급여보다 높을경우 직책의 최대급여를 수정한다
            employee.getJob().maxSalaryCheck(updateSalary);
            employee.setSalary(updateSalary);
            departmentSalaryIncreaseRes.setUpdateSalary(employee.getSalary());
            return departmentSalaryIncreaseRes;
        }).collect(Collectors.toList());
    }
}
