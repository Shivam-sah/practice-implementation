package com.practise.project.serviceimpl;

import org.springframework.stereotype.Service;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.entity.Department;
import com.practise.project.repository.DepartmentRepository;
import com.practise.project.service.DepartmentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository deptRepo;
	private final ObjectMapper objectMapper;
	private final ModelMapper modelMapper;

	@Override
	public Department createdepartment(DepartmentDto req) throws Exception{		
		try {	
			Optional<Department> department = deptRepo.findByDeptCodeAndActive(req.getDeptCode(),true);
			if(department.isPresent()) {
				//throw new RuntimeException();
			}
			Department dept = modelMapper.map(req,Department.class);			
			return deptRepo.save(dept);			
		} catch(Exception ex) {
			throw ex;
		}		
	}

	@Override
	public Department updatedepartment(DepartmentDto req) throws Exception {
		try {
			Optional<Department> department = deptRepo.findByDeptCodeAndActive(req.getDeptCode(),true);
			if(department.isPresent()) {
				department.get().setDeptName(req.getDeptName());
				department.get().setDeptCode(req.getDeptCode());
				department.get().setDescription(req.getDescription());
				deptRepo.save(department.get());
			}
		   // throw 
			return null;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Department getdepartment(Integer id) throws Exception {
		try {
			Optional<Department> dept = deptRepo.findById(id);
			if(dept.isPresent()) {
				return dept.get();
			}
			// throw 			
			return null;
		} catch (Exception ex) {
			throw ex;
		}		
	}

	@Override
	public Boolean deletedepartment(Integer id) throws Exception {
		try {
			Optional<Department> dept = deptRepo.findById(id);
			if(dept.isPresent()) {
				deptRepo.delete(dept.get());
				return true;
			}
			 // throw
			return false;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
