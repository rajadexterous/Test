package com.cts.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages={"com.cts.poc"})// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class UserServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceMain.class, args);
	}
}
