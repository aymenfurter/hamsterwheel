package com.wheel.hamsterwheel;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "hamsterwheel")
public class HamsterwheelConfiguration {
    private int estimatedDurationInSeconds;

    public int getEstimatedDurationInSeconds() {
        return estimatedDurationInSeconds;
    }

    public void setEstimatedDurationInSeconds(int estimatedDurationInSeconds) {
        this.estimatedDurationInSeconds = estimatedDurationInSeconds;
    }
}