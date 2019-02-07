package com.cloud.limits.limitsservice;

import com.cloud.limits.limitsservice.bean.LimitConfiguration;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsConfigurations() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

    @GetMapping("/fault-tolerance-example")
    public LimitConfiguration retrieveConfiguration() {
        throw new RuntimeException();
    }

    @GetMapping("/fault-tolerance-example")
    public LimitConfiguration retrieveConfigurationFallback() {
        throw new RuntimeException();
    }
}
