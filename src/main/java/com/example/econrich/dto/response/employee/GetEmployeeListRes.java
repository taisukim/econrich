package com.example.econrich.dto.response.employee;

import com.example.econrich.domain.Employee;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetEmployeeListRes {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long managerId;
    private String jobId;
    private BigDecimal salary;
    private String phoneNumber;

    public GetEmployeeListRes(Employee employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.managerId = employee.getManager().getId();
        this.jobId = employee.getJob().getId();
        this.salary = employee.getSalary();
        this.phoneNumber = employee.getPhoneNumber().replace("\\.", "-");
    }

}
