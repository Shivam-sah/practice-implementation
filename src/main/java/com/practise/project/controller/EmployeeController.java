package com.practise.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/employee")
public class EmployeeController {
	
	@GetMapping(value="/get-employee")
	public String getEmployee() {
		return "Shivam";
	}

}
