package com.practise.project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.entity.Department;
import com.practise.project.service.DepartmentService;
import com.practise.project.utils.ApiConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiConstant.API_V1 + ApiConstant.EP_DEPTCONTROLLER)
@Slf4j
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	@PostMapping(value = ApiConstant.EP_CREATE_DEPARTMENT)
	public Department createDepartment(@RequestBody DepartmentDto req) throws Exception{
		Department res = departmentService.createdepartment(req);
		return null;
	}
	
	@PutMapping(value = ApiConstant.EP_UPDATE_DEPARTMENT)
	public Department updateDepartment(@RequestBody DepartmentDto req) throws Exception{
		Department res = departmentService.updatedepartment(req);
		return null;
	}
	
	@GetMapping(value = ApiConstant.EP_GET_DEPARTMENT)
	public Department getDepartment(@PathVariable(value = "id") Integer id) throws Exception{
		Department res = departmentService.getdepartment(id);
		return null;
	}
	
	@DeleteMapping(value = ApiConstant.EP_DELETE_DEPARTMENT)
	public Department deleteDepartment(@PathVariable(value = "id") Integer id) throws Exception{
		Boolean res = departmentService.deletedepartment(id);
		return null;
	}
	
}
