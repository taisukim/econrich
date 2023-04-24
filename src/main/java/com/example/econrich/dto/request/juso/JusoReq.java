package com.example.econrich.dto.request.juso;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class JusoReq {


    private int currentPage;
    private int countPerPage;




    private String resultType;

    public JusoReq(){
        this.currentPage = 1;
        this.countPerPage = 20;
        this.resultType = "json";
    }
}
