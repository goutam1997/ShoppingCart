package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequest;
import com.example.demo.model.UserResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserEndpoint {
	
	@Autowired
	private UserService userService;

	@GetMapping("/{userid}/details")
	public UserResponse getUser(@PathVariable long userid) {
		return userService.getUser(userid);
	}
	
	@PostMapping("/add")
	public long getName(@RequestBody UserRequest request) {
		return userService.addUser(request);
	}
	

}
