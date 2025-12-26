package com.practise.project.service;

import com.practise.project.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto getEmployeeById(Integer id) throws Exception;

	EmployeeDto createEmployee(EmployeeDto request);
	
}
