package com.demo.webflux.controllers;

import com.demo.webflux.requests.OnboardingRequest;
import com.demo.webflux.responses.external.OnboardingServiceResponse;
import com.demo.webflux.services.InvokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@RestController
@RequestMapping("/webflux")
@Slf4j
public class ExternalServiceControllers {


    @Autowired
    InvokeService invokeService;

    @PostMapping(value = "/onboarding")
    public Mono<OnboardingServiceResponse> onborading(@RequestBody OnboardingRequest onboardingRequestMono) {
        return invokeService.invokeExternalService("http://localhost:8081/external-service/onboarding",onboardingRequestMono,15).subscribeOn(Schedulers.parallel());
    }

}
