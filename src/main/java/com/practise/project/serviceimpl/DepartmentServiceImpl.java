package com.practise.project.serviceimpl;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.practise.project.builder.Paging;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.entity.Department;
import com.practise.project.exception.BadApiRequestException;
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
	public DepartmentDto updateDepartment(DepartmentDto req) throws Exception {
		try {
			Department department = deptRepo.findByDeptCodeAndActive(req.getDeptCode(), true).orElseThrow(() -> new BadApiRequestException("Department Do not Exists"));
			Department savedDept = deptRepo.save(modelMapper.map(req, Department.class));
			return modelMapper.map(savedDept, DepartmentDto.class);			
		}catch(Exception ex){
			throw ex;
		}
	}
	
	
	@Override
	public DepartmentDto getDepartment(Integer id) throws Exception {
		try {
			Department department = deptRepo.findByIdAndActive(id, true).orElseThrow(() -> new BadApiRequestException("Department Do not Exists"));
			return modelMapper.map(department, DepartmentDto.class);			
		}catch(Exception ex){
			throw ex;
		}
		
	}
	@Override
	public DepartmentDto deleteDepartment(Integer id) throws Exception {
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
	public Page<DepartmentDto> getAllDepartment(Paging req) throws Exception {
		try {
			return null;		
		}catch(Exception ex){
			throw ex;
		}
	}

	
}
