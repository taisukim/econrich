package com.example.econrich.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class Result<T> {
    private T data;

    public Result(T data){
        this.data = data;
    }
}
