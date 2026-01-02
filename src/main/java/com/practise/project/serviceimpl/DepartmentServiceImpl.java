package com.practise.project.serviceimpl;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.practise.project.builder.Paging;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.dto.DepartmentDtoDup;
import com.practise.project.dto.ProjectDto;
import com.practise.project.dto.UpdateDepartmentDto;
import com.practise.project.entity.Department;
import com.practise.project.entity.Project;
import com.practise.project.exception.BadApiRequestException;
import com.practise.project.exception.ResourceNotFoundException;
import com.practise.project.repository.DepartmentRepository;
import com.practise.project.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository deptRepo;
	private final ModelMapper modelMapper;

	@Override
	public DepartmentDto createDepartment(DepartmentDto req) throws Exception {
		try {
			Optional<Department> department = deptRepo.findByDeptCodeAndActive(req.getDeptCode(), true);
			if(department.isPresent()) {
				throw new BadApiRequestException("Department Already Exists");
			}
			Department savedDept = deptRepo.save(modelMapper.map(req, Department.class));
			return modelMapper.map(savedDept, DepartmentDto.class);			
		}catch(Exception ex){
			throw ex;
		}
	}
	
	@Override
	public DepartmentDto updateDepartment(UpdateDepartmentDto req) throws Exception {
		try {
			Department department = deptRepo.findByIdAndActive(req.getId(), true).orElseThrow(() -> new BadApiRequestException("Department Do not Exists"));
			department.setDeptCode(req.getDeptCode());
			department.setDeptName(req.getDeptName());
			department.setDescription(req.getDescription());
			Department savedDept = deptRepo.save(department);
			return modelMapper.map(savedDept, DepartmentDto.class);			
		}catch(Exception ex){
			throw ex;
		}
	}
	
	
	@Override
	public DepartmentDtoDup getDepartment(Long id) throws Exception {
		try {
			Department department = deptRepo.findByIdAndActive(id, true).orElseThrow(() -> new BadApiRequestException("Department Do not Exists"));
			return modelMapper.map(department, DepartmentDtoDup.class);			
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
		
	}
	@Override
	public DepartmentDto deleteDepartment(Long id) throws Exception {
		try {
			Department department = deptRepo.findByIdAndActive(id, true).orElseThrow(() -> new BadApiRequestException("Department Do not Exists"));
			department.setActive(false);
			Department savedDept = deptRepo.save(department);
			return modelMapper.map(savedDept, DepartmentDto.class);			
		}catch(Exception ex){
			throw ex;
		}
	}
	@Override
	public Page<DepartmentDtoDup> getAllDepartment(Paging req) throws Exception {
		try {
			Pageable pageableInstance = req.getPageableInstance();
			Page<Department> departmentList = deptRepo.findByActive(true,pageableInstance);
			if (departmentList.getContent().isEmpty() || departmentList.isEmpty()) {
				throw new ResourceNotFoundException("Project list not found");
			}
			
			Page<DepartmentDtoDup> dtoPage = departmentList.map(department ->
	        	modelMapper.map(department, DepartmentDtoDup.class)
			);
			return dtoPage;	
		}catch(Exception ex){
			throw ex;
		}
	}
	
}
