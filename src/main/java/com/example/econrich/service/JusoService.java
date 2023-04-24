package com.example.econrich.service;

import com.example.econrich.repository.JusoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JusoService {

    private final JusoRepository jusoRepository;


}
