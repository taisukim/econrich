package com.example.econrich.controller;

import com.example.econrich.domain.Department;
import com.example.econrich.dto.Result;
import com.example.econrich.dto.request.department.DepartmentSalaryIncreaseReq;
import com.example.econrich.dto.response.department.DepartmentInfoRes;
import com.example.econrich.dto.response.department.DepartmentLocationInfoRes;
import com.example.econrich.dto.response.department.DepartmentSalaryIncreaseRes;
import com.example.econrich.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping()
    public Result<List<DepartmentInfoRes>> getDepartmentList() {
        List<DepartmentInfoRes> res = departmentService.getDepartmentList();
        return new Result<>(res);
    }

    @GetMapping("/location/{departmentId}")
    public Result<DepartmentLocationInfoRes> getDepartmentLocation(@PathVariable Long departmentId) {
        DepartmentLocationInfoRes res = departmentService.getDepartmentLocation(departmentId);
        return new Result<>(res);
    }

    @PutMapping("/salary/{departmentId}")
    public Result<List<DepartmentSalaryIncreaseRes>> salaryIncreaseByDepartment(@PathVariable Long departmentId
            , @RequestBody @Valid DepartmentSalaryIncreaseReq req){
        List<DepartmentSalaryIncreaseRes> res = departmentService.salaryIncreaseByDepartment(departmentId, req);
        return new Result<>(res);
    }

}
