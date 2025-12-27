package com.practise.project.serviceimpl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practise.project.builder.Paging;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.entity.Department;
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DepartmentDto updateDepartment(DepartmentDto req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DepartmentDto getDepartment(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public DepartmentDto deleteDepartment(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<DepartmentDto> getAllDepartment(Paging req) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
}
