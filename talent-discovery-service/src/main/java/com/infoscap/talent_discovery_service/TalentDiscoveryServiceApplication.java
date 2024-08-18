package com.infoscap.talent_discovery_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TalentDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalentDiscoveryServiceApplication.class, args);
	}

}
