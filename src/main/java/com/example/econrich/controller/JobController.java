package com.example.econrich.controller;

import com.example.econrich.dto.Result;
import com.example.econrich.dto.response.job.JobInfoRes;
import com.example.econrich.dto.response.job.JobLocationInfoRes;
import com.example.econrich.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/job")
public class JobController {

    private final JobService jobService;

    @GetMapping()
    public Result<List<JobInfoRes>> getJobList(){
        List<JobInfoRes> res = jobService.getJobList();
        return new Result<>(res);
    }

//    @GetMapping("/location/{jobId}")
//    public Result<JobLocationInfoRes>
}
