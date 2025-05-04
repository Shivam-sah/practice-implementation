package com.practise.project.service;

import com.practise.project.dto.DepartmentDto;
import com.practise.project.entity.Department;

public interface DepartmentService {

	Department createdepartment(DepartmentDto req) throws Exception;

	Department updatedepartment(DepartmentDto req) throws Exception;

	Department getdepartment(Integer id) throws Exception;

	Boolean deletedepartment(Integer id) throws Exception;
}
