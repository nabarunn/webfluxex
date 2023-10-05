package com.airtelbank.webflux.controllers;

import com.airtelbank.webflux.requests.OnboardingRequest;
import com.airtelbank.webflux.responses.external.OnboardingServiceResponse;
import com.airtelbank.webflux.services.InvokeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@RestController
@RequestMapping("/ncmc")
@Slf4j
public class NcmcControllers {


    @Autowired
    InvokeService invokeService;

    @PostMapping(value = "/onboarding")
    public Mono<OnboardingServiceResponse> onborading(@RequestBody OnboardingRequest onboardingRequestMono) {
        return invokeService.invokeExternalService("http://localhost:8081/ncmc/onboarding",onboardingRequestMono,15).subscribeOn(Schedulers.parallel());
    }

}
