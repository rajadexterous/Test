package com.cts.poc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
@EnableEurekaClient 
@RibbonClient(name="user-service", configuration=LBConfiguration.class)
@EnableCircuitBreaker
@EnableHystrixDashboard
public class UserLoadBalancer {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	UserCircuitBreakerService userService;
	
	/*@Autowired
    private DiscoveryClient discoveryClient;
	*/
	
	@RequestMapping("/user")
	public List getUserList() {
		/*System.out.println("--------getUserList-------------------"+discoveryClient.toString());
		List<ServiceInstance> serviceInstanceList = this.discoveryClient.getInstances("testRajaUserService");
		System.out.println("--------"+serviceInstanceList.size());
		for(ServiceInstance servInstance : serviceInstanceList) {
			System.out.println("--------"+servInstance.getServiceId());
			System.out.println("--------"+servInstance.getUri());
		}*/
		List users = userService.getUserList();
		//List users = this.restTemplate.getForObject("http://testRajaUserService/user", List.class);
		return users;
	}

	/*@RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }*/
	
	public static void main(String[] args) {
		SpringApplication.run(UserLoadBalancer.class, args);
	}
}
