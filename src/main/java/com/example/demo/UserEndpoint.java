package com.example.demo.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

	@GetMapping("/{userid}/details")
	public String getName() {
		return "Goutam";
	}
	
	@PostMapping("/add")
	public String getName(@RequestBody UserRequest request) {
		System.out.print("rider : "+rider.toString());
		return "Goutam "+rider.getName();
	}
	

}
