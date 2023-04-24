package com.example.econrich.dto.response.department;

import com.example.econrich.domain.Employee;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepartmentSalaryIncreaseRes {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private BigDecimal beforeSalary;
    private BigDecimal updateSalary;

    public DepartmentSalaryIncreaseRes(Employee employee) {
        this.employeeId = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.beforeSalary = employee.getSalary();
        this.updateSalary = BigDecimal.valueOf(0);
    }

    public void setUpdateSalary(BigDecimal updateSalary){
        this.updateSalary = updateSalary;
    }
}
