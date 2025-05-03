package com.practise.project.controller;
 
import com.practise.project.utils.ApiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ApiConstant.API_V1 + ApiConstant.EP_EMPCONTROLLER)
public class EmployeeController {
	
	@GetMapping(value="/get-employee")
	public String getEmployee() {
		return "Shivam";
	}

}
