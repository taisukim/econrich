package com.example.econrich.service;

import com.example.econrich.dto.request.juso.JusoReq;
import com.example.econrich.dto.response.juso.JusoRes;
import com.example.econrich.repository.JusoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JusoService {

    private final JusoRepository jusoRepository;


    public Map findJusoList(String juso, JusoReq req) {
        Map res = jusoRepository.findJusoList(juso, req);
        return res;

    }
}
