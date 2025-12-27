package com.practise.project.service;

import com.practise.project.dto.EmployeeDto;

import jakarta.validation.Valid;

public interface EmployeeService {

	EmployeeDto getEmployeeById(Integer id) throws Exception;

	EmployeeDto createEmployee(EmployeeDto request);
	
	EmployeeDto deleteEmployeeById(Integer id);

	EmployeeDto updateEmployee(@Valid EmployeeDto request);
	
}
