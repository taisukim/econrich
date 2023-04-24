package com.example.econrich.controller;

import com.example.econrich.dto.Result;
import com.example.econrich.dto.request.juso.JusoReq;
import com.example.econrich.dto.response.juso.JusoRes;
import com.example.econrich.service.JusoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/juso")
public class JusoController {

    private final JusoService jusoService;

    @GetMapping("/{juso}")
    public Result<List<JusoRes>> findJusoList(@PathVariable String juso, @RequestBody @Valid JusoReq req){

    }

}
