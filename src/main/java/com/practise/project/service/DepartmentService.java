package com.practise.project.service;

import org.springframework.data.domain.Page;

import com.practise.project.builder.Paging;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.dto.UpdateDepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto req) throws Exception;

	DepartmentDto updateDepartment(UpdateDepartmentDto req) throws Exception;

	DepartmentDto getDepartment(Integer id) throws Exception;

	DepartmentDto deleteDepartment(Integer id) throws Exception;
	
	Page<DepartmentDto> getAllDepartment(Paging req) throws Exception;
}
