package com.example.econrich.service;

import com.example.econrich.domain.Job;
import com.example.econrich.dto.response.job.JobInfoRes;
import com.example.econrich.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JobService {
    private final JobRepository jobRepository;


    public List<JobInfoRes> getJobList() {
        List<Job> jobList = jobRepository.findAll();
        return jobList.stream().map(JobInfoRes::new).collect(Collectors.toList());
    }
}
