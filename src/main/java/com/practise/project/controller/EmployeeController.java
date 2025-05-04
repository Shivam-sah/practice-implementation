package com.practise.project.controller;
 
import com.practise.project.entity.Employee;
import com.practise.project.service.EmployeeService;
import com.practise.project.utils.ApiConstant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiConstant.API_V1 + ApiConstant.EP_EMPCONTROLLER)
@Slf4j
public class EmployeeController {
	
	private final EmployeeService empService;
	
	@GetMapping(value= "/get-employee/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable(value = "id")Integer id) throws Exception{
		Employee res = empService.getEmployeeById(id);
		return null;
	}

}
