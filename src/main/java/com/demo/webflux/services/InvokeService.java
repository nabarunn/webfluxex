package com.demo.webflux.services;

import com.demo.webflux.responses.external.OnboardingServiceResponse;
import reactor.core.publisher.Mono;

public interface InvokeService {

    public Mono<OnboardingServiceResponse> invokeExternalService(String url, Object requestBody, int timeOutInSeconds);
}
