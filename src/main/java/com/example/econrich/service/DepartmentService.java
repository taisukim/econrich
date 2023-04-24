package com.example.econrich.service;

import com.example.econrich.domain.Department;
import com.example.econrich.domain.Employee;
import com.example.econrich.dto.request.department.DepartmentSalaryIncreaseReq;
import com.example.econrich.dto.response.department.DepartmentInfoRes;
import com.example.econrich.dto.response.department.DepartmentLocationInfoRes;
import com.example.econrich.dto.response.department.DepartmentSalaryIncreaseRes;
import com.example.econrich.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public List<DepartmentInfoRes> getDepartmentList() {
        List<Department> departmentList = departmentRepository.findAll();
        return departmentList.stream().map(DepartmentInfoRes::new).collect(Collectors.toList());

    }

    public DepartmentLocationInfoRes getDepartmentLocation(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isPresent()){
            return new DepartmentLocationInfoRes(department.get());
        }else{
            throw new IllegalArgumentException("해당 부서가 존재하지 않습니다.");
        }
    }

    @Transactional
    public List<DepartmentSalaryIncreaseRes> salaryIncreaseByDepartment(Long departmentId, DepartmentSalaryIncreaseReq req) {
        Department department = departmentRepository.findEmployeeByDepartmentId(departmentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 부서입니다."));
        return department.salaryIncrease(req);
    }
}
