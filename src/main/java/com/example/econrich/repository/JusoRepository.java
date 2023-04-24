package com.example.econrich.repository;

import com.example.econrich.config.WebClientConfig;
import com.example.econrich.dto.request.juso.JusoReq;
import com.example.econrich.dto.response.juso.JusoRes;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JusoRepository {

    private final WebClientConfig webClientConfig;

    @Value("${juso.apikey}")
    private String confmKey;

    public Map findJusoList(String juso, JusoReq req) {
        WebClient webClient = webClientConfig.webClient();
        Mono<Map> res = webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/addrlink/addrLinkApi.do")
                        .queryParam("keyword", juso)
                        .queryParam("currentPage", req.getCurrentPage())
                        .queryParam("countPerPage", req.getCountPerPage())
                        .queryParam("resultType", req.getResultType())
                        .queryParam("confmKey", confmKey)
                        .build()
                )
                .header("accept", "application/json")
                .retrieve()
                .bodyToMono(Map.class);
        return res.block();
    }
}
