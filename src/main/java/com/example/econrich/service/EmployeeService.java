package com.example.econrich.service;

import com.example.econrich.domain.Employee;
import com.example.econrich.domain.JobHistory;
import com.example.econrich.dto.response.employee.GetEmployeeHistoryInfoRes;
import com.example.econrich.dto.response.employee.GetEmployeeInfoRes;
import com.example.econrich.dto.response.employee.GetEmployeeListRes;
import com.example.econrich.repository.EmployeeRepository;
import com.example.econrich.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final JobHistoryRepository jobHistoryRepository;

    public List<GetEmployeeListRes> getEmployeeList() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<GetEmployeeListRes> res = employeeList.stream().map(GetEmployeeListRes::new).collect(Collectors.toList());
        return res;
    }

    public GetEmployeeInfoRes getEmployeeInfo(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(employee.isPresent()){
            return new GetEmployeeInfoRes(employee.get());
        }else{
            throw new IllegalArgumentException("해당 회원이 존재하지 않습니다.");
        }
    }

    public List<GetEmployeeHistoryInfoRes> getEmployeeHistory(Long employeeId) {
        List<JobHistory> historyList = jobHistoryRepository.findById(employeeId);
        return historyList.stream().map(GetEmployeeHistoryInfoRes::new).collect(Collectors.toList());
    }
}
