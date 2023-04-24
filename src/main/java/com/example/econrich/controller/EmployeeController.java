package com.example.econrich.controller;

import com.example.econrich.dto.response.employee.GetEmployeeHistoryInfoRes;
import com.example.econrich.dto.response.employee.GetEmployeeInfoRes;
import com.example.econrich.dto.Result;
import com.example.econrich.dto.response.employee.GetEmployeeListRes;
import com.example.econrich.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Result<List<GetEmployeeListRes>> getEmployeeList(){
        List<GetEmployeeListRes> res = employeeService.getEmployeeList();
        return new Result<List<GetEmployeeListRes>>(res);
    }

    @GetMapping("/{employeeId}")
    public Result<GetEmployeeInfoRes> getEmployeeInfo(@PathVariable Long employeeId){
        GetEmployeeInfoRes res = employeeService.getEmployeeInfo(employeeId);
        return new Result<>(res);
    }

    @GetMapping("/history/{employeeId}")
    public Result<List<GetEmployeeHistoryInfoRes>> getEmployeeHistory(@PathVariable Long employeeId) {
        List<GetEmployeeHistoryInfoRes> res = employeeService.getEmployeeHistory(employeeId);
        return new Result<>(res);
    }


}
