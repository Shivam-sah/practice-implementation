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
import com.practise.project.dto.ProjectDto;
import com.practise.project.dto.ProjectDtoDup;
import com.practise.project.dto.UpdateProjectDto;
import com.practise.project.service.ProjectService;
import com.practise.project.utils.ApiConstant;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiConstant.API_V1 + ApiConstant.EP_PROJECTCONTROLLER)
@Slf4j
public class ProjectsController {
	
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
	public ResponseEntity<ApiResponse> getProject(@PathVariable Long id) throws Exception {
		log.info("projectcontroller::getproject " + id);
		try {
			ProjectDtoDup project = projectService.getProject(id);
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
	public ResponseEntity<ApiResponse> deleteProject(@PathVariable Long id) throws Exception {
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
	public ResponseEntity<ApiResponse> updateProject(@RequestBody @Valid UpdateProjectDto request) throws Exception {
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
			Page<ProjectDtoDup> projects = projectService.getAllProject(req);
			 return ApiResponseBuilder.getPaginationSuccessResponse(projects, "Project List", HttpStatus.OK);
		} catch (BadApiRequestException ex) {
			log.error("bad api request in fetching all project", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			log.error("exception in fetching all project");
			return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
		}
	}

}
