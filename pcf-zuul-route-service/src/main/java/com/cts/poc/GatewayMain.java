package com.cts.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
//@EnableEurekaClient
public class GatewayMain {

	public static void main(String[] args) {
	    SpringApplication.run(GatewayMain.class, args);
	  }

	  @Bean
	  public SimplePreFilter simplePreFilter() {
	    return new SimplePreFilter();
	  }
}
