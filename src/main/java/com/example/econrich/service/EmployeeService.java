package com.example.econrich.service;

import com.example.econrich.domain.Employee;
import com.example.econrich.dto.response.employee.GetEmployeeListRes;
import com.example.econrich.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<GetEmployeeListRes> getEmployeeList() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<GetEmployeeListRes> res = employeeList.stream().map(GetEmployeeListRes::new).collect(Collectors.toList());
        return res;
    }
}
