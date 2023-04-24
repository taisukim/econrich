package com.example.econrich.dto.request.juso;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
public class JusoReq {


    private int currentPage = 1;
    private int countPerPage = 20;


    private String keyword;

    @Value("${juso.apikey}")
    private String confmKey;

    private String resultType = "json";
}
