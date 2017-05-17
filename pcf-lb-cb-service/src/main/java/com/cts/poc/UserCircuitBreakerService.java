package com.cts.poc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserCircuitBreakerService {

	private RestTemplate restTemplate;

  public UserCircuitBreakerService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
  
  @HystrixCommand(fallbackMethod = "getUserListFB")
  public List getUserList() {
	  return this.restTemplate.getForObject("http://testRajaUserService/user", List.class);
  }
  
  public List getUserListFB() {
	  List fbList = new ArrayList();
	  fbList.add("Admin User : Raja");
	  return fbList;
  }
}
