package com.airtelbank.webflux.services.impl;

import com.airtelbank.webflux.responses.external.OnboardingServiceResponse;
import com.airtelbank.webflux.services.InvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class InvokeOnboardingServiceImpl implements InvokeService {

    @Autowired
    WebClient webClient;

    @Override
    public Mono<OnboardingServiceResponse> invokeExternalService(String url, Object requestBody, int timeOutInSeconds) {
        return webClient.post()
                .uri(url)
                .headers(httpHeaders -> httpHeaders.add("Content-Type","application/json"))
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(OnboardingServiceResponse.class)
                .timeout(Duration.ofSeconds(timeOutInSeconds));
    }
}
