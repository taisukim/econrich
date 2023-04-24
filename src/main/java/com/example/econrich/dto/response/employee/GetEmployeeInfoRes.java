package com.example.econrich.dto.response.employee;

import com.example.econrich.domain.Employee;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetEmployeeInfoRes {
    private Long employeeId;
    private String jobId;
    private Long managerId;
    private Long departmentId;
    private Long locationId;
    private String countryId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String jobTitle;
    private String city;
    private String stateProvince;
    private String countryName;
    private String regionName;

    public GetEmployeeInfoRes(Employee employee){
        this.employeeId = employee.getId();
        this.jobId = employee.getJob().getId();
        this.managerId = employee.getManager().getId();
        this.departmentId = employee.getDepartment().getId();
        this.locationId = employee.getDepartment().getLocation().getId();
        this.countryId = employee.getDepartment().getLocation().getCountry().getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.salary = employee.getSalary();
        this.jobTitle = employee.getJob().getTitle();
        this.city = employee.getDepartment().getLocation().getCity();
        this.stateProvince = employee.getDepartment().getLocation().getStateProvince();
        this.countryName = employee.getDepartment().getLocation().getCountry().getName();
        this.regionName = employee.getDepartment().getLocation().getCountry().getRegion().getName();
    }
}
