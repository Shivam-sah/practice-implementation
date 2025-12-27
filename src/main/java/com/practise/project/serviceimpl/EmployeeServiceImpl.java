package com.practise.project.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.practise.project.dto.EmployeeDto;
import com.practise.project.dto.ProjectDto;
import com.practise.project.entity.Employee;
import com.practise.project.entity.Project;
import com.practise.project.entity.Employee;
import com.practise.project.exception.BadApiRequestException;
import com.practise.project.repository.EmployeeRepository;
import com.practise.project.repository.ProjectRepository;
import com.practise.project.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final ModelMapper modelMapper;
	private final EmployeeRepository employeeRepo;
	private final ProjectRepository projectRepository;
	

	@Override
	public EmployeeDto getEmployeeById(Integer id) throws Exception{
		try {
			Employee employee = employeeRepo.findByIdAndActive(id, true).orElseThrow( () -> new BadApiRequestException("Employee with this Id do not exists"));	
			System.out.println(employee);
			return modelMapper.map(employee, EmployeeDto.class);			
		}catch (Exception ex) {
			throw ex;
		}
	}


	@Override
	public EmployeeDto createEmployee(EmployeeDto request) {
		try {
			Optional<Employee> emp = employeeRepo.findByMobileNumberAndActive(request.getMobileNumber(),true);
			if(emp.isPresent()) {
				throw new BadApiRequestException("Employee Already exists");
			}
			Set<Project> projects = null;
			if (!request.getProjectIds().isEmpty()) {
			    projects = request.getProjectIds().stream()
			        .map(id -> projectRepository.findByIdAndActive(id, true)
			            .orElseThrow(() -> new RuntimeException("Project not found: " + id)))
			        .collect(Collectors.toSet());
			}

			Employee employee = modelMapper.map(request, Employee.class);
			employee.getProfile().setEmployee(employee);
			employee.setProjects(projects);
			Employee savedEmployee = employeeRepo.save(employee);			
			return modelMapper.map(savedEmployee, EmployeeDto.class);			
		}catch(Exception Ex) {
			throw Ex;
		}
	}


	@Override
	public EmployeeDto deleteEmployeeById(Integer id) {
		try {			
			Optional<Employee> employee = employeeRepo.findByIdAndActive(id, true);
			if (!employee.isPresent()) {
				throw new BadApiRequestException("Employee with this Id do not exists");
			}	
			
			Employee deletedEmployee = employee.get();
			deletedEmployee.setActive(false);
			Employee savedEmployee = employeeRepo.save(deletedEmployee);
			return modelMapper.map(savedEmployee, EmployeeDto.class);			
		}catch(Exception ex) {
			throw ex;
		}
	}


	@Override
	public EmployeeDto updateEmployee(@Valid EmployeeDto request) {
		try {
			Employee emp = employeeRepo.findByMobileNumberAndActive(request.getMobileNumber(), true).orElseThrow( () -> new BadApiRequestException("Employee with this Id do not exists"));
			Set<Project> projects = null;
			if (!request.getProjectIds().isEmpty()) {
			    projects = request.getProjectIds().stream()
			        .map(id -> projectRepository.findByIdAndActive(id, true)
			            .orElseThrow(() -> new RuntimeException("Project not found: " + id)))
			        .collect(Collectors.toSet());
			}
			
			
			Employee employee = modelMapper.map(request, Employee.class);
			employee.getProfile().setEmployee(employee);
			employee.setProjects(projects);
			Employee savedEmployee = employeeRepo.save(employee);			
			return modelMapper.map(savedEmployee, EmployeeDto.class);						
		}catch(Exception ex) {
			throw ex;
		}
	}

}
