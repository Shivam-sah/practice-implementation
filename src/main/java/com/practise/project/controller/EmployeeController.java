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
import com.practise.project.builder.ApiResponse;
import com.practise.project.builder.ApiResponseBuilder;
import com.practise.project.builder.Paging;
import com.practise.project.dto.EmployeeDto;
import com.practise.project.dto.ProjectDto;
import com.practise.project.exception.BadApiRequestException;
import com.practise.project.service.EmployeeService;
import com.practise.project.service.ProjectService;
import com.practise.project.utils.ApiConstant;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiConstant.API_V1 + ApiConstant.EP_EMPCONTROLLER)
@Slf4j
public class EmployeeController {
	
	private final EmployeeService empService;
	
	private final ProjectService projectService;
	
	
	@PostMapping(value = ApiConstant.EP_CREATE_PROJECT)
    @Operation(summary = "Create Project", description = "Create Project")
    public ResponseEntity<ApiResponse> createProject(@RequestBody @Valid ProjectDto request) throws Exception {
        log.info("projectcontroller::createproject " + request);
        try {
        	ProjectDto project = projectService.createProject(request);
        	return ApiResponseBuilder.getSuccessResponse(project, "Project created successfully", HttpStatus.CREATED);
        } catch (BadApiRequestException ex) {
            log.error("bad api request in creatign project", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("exception in creating project");
            return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
	
	
	@GetMapping(value = ApiConstant.EP_GET_PROJECT)
	@Operation(summary = "Get Project", description = "Get Project")
	public ResponseEntity<ApiResponse> getProject(@PathVariable Integer id) throws Exception {
		log.info("projectcontroller::getproject " + id);
		try {
			ProjectDto project = projectService.getProject(id);
			return ApiResponseBuilder.getSuccessResponse(project, "Project fetched successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in fetching project", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in fetching project");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	
	@DeleteMapping(value = ApiConstant.EP_DELETE_PROJECT)
	@Operation(summary = "Delete Project", description = "Delete Project")
	public ResponseEntity<ApiResponse> deleteProject(@PathVariable Integer id) throws Exception {
		log.info("projectcontroller::deleteproject " + id);
		try {
			ProjectDto res = projectService.deleteProject(id);
			return ApiResponseBuilder.getSuccessResponse(res, "Project Deleted successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in deleting project", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in deleting project");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	@PutMapping(value = ApiConstant.EP_UPDATE_PROJECT)
	@Operation(summary = "Update Project", description = "Update Project")
	public ResponseEntity<ApiResponse> updateProject(@RequestBody @Valid ProjectDto request) throws Exception {
		log.info("projectcontroller::updateproject " + request);
		try {
			ProjectDto res = projectService.updateProject(request);
			return ApiResponseBuilder.getSuccessResponse(res, "Project Updated successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in updating project", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in updating project");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	
	@PostMapping(value = ApiConstant.EP_ALL_PROJECT)
	@Operation(summary = "Get All Project", description = "Get All Project")
	public ResponseEntity<ApiResponse> getAllProject(@RequestBody Paging req) throws Exception {
		log.info("projectcontroller::getAllproject " + req);
		try {
			Page<ProjectDto> projects = projectService.getAllProject(req);
			 return ApiResponseBuilder.getPaginationSuccessResponse(projects, "Project List", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in fetching all project", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in fetching all project");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	@PostMapping(value = ApiConstant.EP_CREATE_EMPLOYEE)
    @Operation(summary = "Create Employee", description = "Create Employee")
    public ResponseEntity<ApiResponse> createEmployee(@RequestBody @Valid EmployeeDto request) throws Exception {
        log.info("employeecontroller::createemployee " + request);
        try {
        	EmployeeDto project = empService.createEmployee(request);
        	return ApiResponseBuilder.getSuccessResponse(project, "Employee created successfully", HttpStatus.CREATED);
        } catch (BadApiRequestException ex) {
            log.error("bad api request in creatign employee", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("exception in creating employee");
            return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
	
	
	@GetMapping(value = ApiConstant.EP_GET_EMPLOYEE)
	@Operation(summary = "Get Employee", description = "Get Employee")
	public ResponseEntity<ApiResponse> getEmployee(@PathVariable Integer id) throws Exception {
		log.info("projectcontroller::getEmployee " + id);
		try {
			EmployeeDto employee = empService.getEmployeeById(id);
			return ApiResponseBuilder.getSuccessResponse(employee , "Employee fetched successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in fetching employee", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in fetching employee");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	@DeleteMapping(value = ApiConstant.EP_DELETE_EMPLOYEE)
	@Operation(summary = "Delete Project", description = "Delete Project")
	public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Integer id) throws Exception {
		log.info("projectcontroller::deleteproject " + id);
		try {
			EmployeeDto res = empService.deleteEmployeeById(id);
			return ApiResponseBuilder.getSuccessResponse(res, "Employee Deleted successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in deleting employee", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in deleting employee");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	
	
	@PutMapping(value = ApiConstant.EP_UPDATE_EMPLOYEE)
	@Operation(summary = "Update Employee", description = "Update Employee")
	public ResponseEntity<ApiResponse> updateEmployee(@RequestBody @Valid EmployeeDto request) throws Exception {
		log.info("projectcontroller::deleteproject " + request);
		try {
			EmployeeDto res = empService.updateEmployee(request);
			return ApiResponseBuilder.getSuccessResponse(res, "Project Updated successfully", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in updating project", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in updating project");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}
	

}
