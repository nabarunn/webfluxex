package com.demo.webflux.responses.external;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OnboardingServiceResponse {

    private String customerType;
    private String status;
}
