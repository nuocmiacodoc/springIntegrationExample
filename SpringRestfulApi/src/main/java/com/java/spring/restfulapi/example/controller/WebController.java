package com.java.spring.restfulapi.example.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebController {
	
	@GetMapping("/get")
	public String getServerTime(){
		
		System.out.println("# GET Request!");

		final String request = "This is request data from restful server";

		return request;
	}

	@PostMapping("/post")
	public String postServerTime(@RequestBody String requestData){

		System.out.println("# POST Request!");
		System.out.println("Posted data: " + requestData);
		return "OK";
	}
	
}