package com.practise.project.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.authlibrary.builder.ApiResponse;
import com.authlibrary.builder.ApiResponseBuilder;
import com.authlibrary.builder.Paging;
import com.authlibrary.exception.BadApiRequestException;
import com.practise.project.dto.DepartmentDto;
import com.practise.project.dto.DepartmentDtoDup;
import com.practise.project.dto.UpdateDepartmentDto;
import com.practise.project.service.DepartmentService;
import com.practise.project.utils.ApiConstant;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    @Operation(summary = "Create Department", description = "Create Department")
    public ResponseEntity<ApiResponse> createProject(@RequestBody @Valid DepartmentDto request) throws Exception {
        log.info("projectcontroller::createDepartment " + request);
        try {
        	DepartmentDto department = departmentService.createDepartment(request);
        	return ApiResponseBuilder.getSuccessResponse(department, "Department created successfully", HttpStatus.CREATED);
        } catch (BadApiRequestException ex) {
            log.error("bad api request in creatign Department", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("exception in creating Department");
            return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
	
	
	@GetMapping(value = ApiConstant.EP_GET_DEPARTMENT)
	@Operation(summary = "Get Department", description = "Get Department")
	public ResponseEntity<ApiResponse> getProject(@PathVariable Long id) throws Exception {
		log.info("projectcontroller::getDepartment " + id);
		try {
			DepartmentDtoDup department = departmentService.getDepartment(id);
			return ApiResponseBuilder.getSuccessResponse(department, "Department fetched successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in fetching Department", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in fetching Department");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	
	@DeleteMapping(value = ApiConstant.EP_DELETE_DEPARTMENT)
	@Operation(summary = "Delete Department", description = "Delete Department")
	public ResponseEntity<ApiResponse> deleteProject(@PathVariable Long id) throws Exception {
		log.info("projectcontroller::deleteDepartment " + id);
		try {
			DepartmentDto res = departmentService.deleteDepartment(id);
			return ApiResponseBuilder.getSuccessResponse(res, "Department Deleted successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in deleting Department", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in deleting Department");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	@PutMapping(value = ApiConstant.EP_UPDATE_DEPARTMENT)
	@Operation(summary = "Update Department", description = "Update Department")
	public ResponseEntity<ApiResponse> updateProject(@RequestBody @Valid UpdateDepartmentDto request) throws Exception {
		log.info("projectcontroller::updateDepartment " + request);
		try {
			DepartmentDto res = departmentService.updateDepartment(request);
			return ApiResponseBuilder.getSuccessResponse(res, "Department Updated successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in updating Department", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in updating Department");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
		
	
	@PostMapping(value = ApiConstant.EP_ALL_DEPARTMENT)
	@Operation(summary = "Get All Department", description = "Get All Department")
	public ResponseEntity<ApiResponse> getAllProject(@RequestBody Paging req) throws Exception {
		log.info("projectcontroller::getAllDepartment " + req);
		try {
			Page<DepartmentDtoDup> departments = departmentService.getAllDepartment(req);
			 return ApiResponseBuilder.getPaginationSuccessResponse(departments, "Department List", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in fetching all Department", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in fetching all Department");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
}
