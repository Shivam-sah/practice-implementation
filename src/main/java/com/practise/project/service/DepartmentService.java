package com.practise.project.service;

import org.springframework.data.domain.Page;
import com.authlibrary.builder.Paging;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.dto.DepartmentDtoDup;
import com.practise.project.dto.UpdateDepartmentDto;

public interface DepartmentService {

	DepartmentDto createDepartment(DepartmentDto req) throws Exception;

	DepartmentDto updateDepartment(UpdateDepartmentDto req) throws Exception;

	DepartmentDtoDup getDepartment(Long id) throws Exception;

	DepartmentDto deleteDepartment(Long id) throws Exception;
	
	Page<DepartmentDtoDup> getAllDepartment(Paging req) throws Exception;
}
