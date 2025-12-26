package com.practise.project.serviceimpl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.practise.project.dto.EmployeeDto;
import com.practise.project.entity.Employee;
import com.practise.project.repository.EmployeeRepository;
import com.practise.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final ModelMapper modelMapper;
	private final EmployeeRepository employeeRepo;	
	

	@Override
	public EmployeeDto getEmployeeById(Integer id) throws Exception{
		try {
			
		}catch (Exception ex) {
			throw ex;
		}
		return null;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto request) {
		try {
			employeeRepo.save(modelMapper.map(request, Employee.class));
			
			
			return null;
			
		}catch(Exception Ex) {
			throw Ex;
		}
	}

}
