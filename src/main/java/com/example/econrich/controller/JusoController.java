package com.example.econrich.controller;

import com.example.econrich.dto.Result;
import com.example.econrich.dto.request.juso.JusoReq;
import com.example.econrich.service.JusoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/juso")
public class JusoController {

    private final JusoService jusoService;

    @GetMapping("/{juso}")
    public Result<Map> findJusoList(@PathVariable String juso, @ModelAttribute @Valid JusoReq req){
        Map res = jusoService.findJusoList(juso, req);
        System.out.println(req);
        return new Result<>(res);
    }

}
