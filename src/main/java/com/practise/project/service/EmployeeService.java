package com.practise.project.service;

import org.springframework.data.domain.Page;

import com.practise.project.builder.Paging;
import com.practise.project.dto.EmployeeCreateDto;
import com.practise.project.dto.EmployeeDto;
import com.practise.project.dto.EmployeeUpdateDto;

import jakarta.validation.Valid;

public interface EmployeeService {

	EmployeeDto getEmployeeById(Long id) throws Exception;

	EmployeeDto createEmployee(EmployeeCreateDto request);
	
	EmployeeDto deleteEmployeeById(Long id);

	EmployeeDto updateEmployee(@Valid EmployeeUpdateDto request);

	Page<EmployeeDto> getAllEmployee(Paging req);	
}
