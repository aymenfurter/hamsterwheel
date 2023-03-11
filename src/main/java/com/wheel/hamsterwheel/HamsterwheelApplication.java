package com.wheel.hamsterwheel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class HamsterwheelApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(HamsterwheelApplication.class);
    private static final String QUEUE_NAME = "seeds";
    private static final String TARGET_QUEUE_NAME = "cheeks";

    @Autowired
    private JmsTemplate jmsTemplate;

	@Autowired
    private HamsterwheelConfiguration hamsterwheelConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(HamsterwheelApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("Starting up");
    }

    @JmsListener(destination = QUEUE_NAME, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(String message) {
        LOGGER.info("Message received: {}", message);
		wheelrun();
    }

	private void wheelrun() {
		long startTime = System.currentTimeMillis();
		int estimatedDurationInSeconds = hamsterwheelConfiguration.getEstimatedDurationInSeconds();

		for (int i = 0; i < 4000000 * estimatedDurationInSeconds; i++) {
			double a = Math.random() * Math.random();
			double b = Math.random() * Math.random();
			double c = Math.random() * Math.random();
			double d = Math.random() * Math.random();
			double e = Math.random() * Math.random();
			double f = Math.random() * Math.random();
			double result = (a + b + c + d + e + f) / 6;
		}

		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println("Elapsed time: " + elapsedTime + "ms");
        jmsTemplate.convertAndSend(TARGET_QUEUE_NAME, "sunflower-seed");
	}

}