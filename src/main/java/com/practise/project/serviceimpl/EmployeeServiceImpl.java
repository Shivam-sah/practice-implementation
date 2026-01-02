package com.practise.project.serviceimpl;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.authlibrary.builder.Paging;
import com.authlibrary.exception.BadApiRequestException;
import com.authlibrary.exception.ResourceNotFoundException;
import com.practise.project.dto.EmployeeCreateDto;
import com.practise.project.dto.EmployeeDto;
import com.practise.project.dto.EmployeeUpdateDto;
import com.practise.project.entity.Department;
import com.practise.project.entity.Employee;
import com.practise.project.entity.Profile;
import com.practise.project.entity.Project;
import com.practise.project.repository.DepartmentRepository;
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
	private final DepartmentRepository deptRepo;
	

	@Override
	public EmployeeDto getEmployeeById(Long id) throws Exception{
		try {
			Employee employee = employeeRepo.findByIdAndActive(id, true).orElseThrow( () -> new BadApiRequestException("Employee with this Id do not exists"));	
			return modelMapper.map(employee, EmployeeDto.class);			
		}catch (Exception ex) {
			throw ex;
		}
	}


	@Override
	public EmployeeDto createEmployee(EmployeeCreateDto request) {
		try {

		    employeeRepo.findByMobileNumberAndActive(request.getMobileNumber(), true)
		            .ifPresent(emp -> {
		                throw new BadApiRequestException("Employee already exists");
		            });

		    Set<Project> projects = Collections.emptySet();
		    if (request.getProjectIds() != null && !request.getProjectIds().isEmpty()) {
		        projects = request.getProjectIds().stream()
		                .map(id -> projectRepository.findByIdAndActive(id, true)
		                        .orElseThrow(() -> new BadApiRequestException("Project not found: " + id)))
		                .collect(Collectors.toSet());
		    }

		    Department department = null;
		    if (request.getDepartmentId() != null) {
		        department = deptRepo.findByIdAndActive(request.getDepartmentId(), true)
		                .orElseThrow(() -> new BadApiRequestException("Department does not exist"));
		    }

		    Employee employee = modelMapper.map(request, Employee.class);
		    employee.setId(null);
		    employee.setProjects(projects);
		    employee.setDepartment(department);
		    employee.setProfile(employee.getProfile());

		    Employee savedEmployee = employeeRepo.save(employee);
		    
		    return modelMapper.map(savedEmployee, EmployeeDto.class);			
		}catch(Exception Ex) {
			Ex.printStackTrace();
			throw Ex;
		}
	}


	@Override
	public EmployeeDto deleteEmployeeById(Long id) {
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
	public EmployeeDto updateEmployee(@Valid EmployeeUpdateDto request) {
		try {
			Employee emp = employeeRepo.findByIdAndActive(request.getId(), true).orElseThrow( () -> new BadApiRequestException("Employee with this Id do not exists"));
			Set<Project> projects = null;
			if (!request.getProjectIds().isEmpty()) {
			    projects = request.getProjectIds().stream()
			        .map(id -> projectRepository.findByIdAndActive(id, true)
			            .orElseThrow(() -> new RuntimeException("Project not found: " + id)))
			        .collect(Collectors.toSet());
			}
			
			Department department = null;
		    if (request.getDepartmentId() != null) {
		        department = deptRepo.findByIdAndActive(request.getDepartmentId(), true)
		                .orElseThrow(() -> new BadApiRequestException("Department does not exist"));
		    }
		    
		    emp.setProjects(projects);
		    emp.setDepartment(department);
		    emp.setProfile(modelMapper.map(request.getProfile(), Profile.class));
		    emp.setName(request.getName());
		    emp.setEmail(request.getEmail());

		    Employee savedEmployee = employeeRepo.save(emp);			
		    return modelMapper.map(savedEmployee, EmployeeDto.class);																
		}catch(Exception ex) {
			throw ex;
		}
	}


	@Override
	public Page<EmployeeDto> getAllEmployee(Paging req) {
		try {
			Pageable pageableInstance = req.getPageableInstance();
			Page<Employee> employeeList = employeeRepo.findByActive(true,pageableInstance);
			if (employeeList.getContent().isEmpty() || employeeList.isEmpty()) {
				throw new ResourceNotFoundException("Project list not found");
			}
			
			Page<EmployeeDto> dtoPage = employeeList.map(employee ->
	        	modelMapper.map(employee, EmployeeDto.class)
			);
			return dtoPage;			
		}catch(Exception ex) {
			throw ex;
		}
		
	}

}
