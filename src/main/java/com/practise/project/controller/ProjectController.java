package com.practise.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practise.project.builder.ApiResponse;
import com.practise.project.builder.ApiResponseBuilder;
import com.practise.project.dto.ProjectDto;
import com.practise.project.entity.Project;
import com.practise.project.exception.BadApiRequestException;
import com.practise.project.repository.ProjectRepository;
import com.practise.project.service.DepartmentService;
import com.practise.project.service.ProjectService;
import com.practise.project.utils.ApiConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = ApiConstant.API_V1 + ApiConstant.EP_PROJECTCONTROLLER)
@Slf4j
public class ProjectController {
	
	private final ProjectService projectService;
	
	
	@PostMapping(value = ApiConstant.EP_CREATE_PROJECT)
    @Operation(summary = "Create Project", description = "Create Project")
    public ResponseEntity<?> createProject(@RequestBody ProjectDto request) throws Exception {
        log.info("projectcontroller::createproject " + request);
        try {
        //	ProjectDto project = projectService.createProject(request);
        	return ApiResponseBuilder.getSuccessResponse(null, "Project created successfully", HttpStatus.CREATED);
        } catch (BadApiRequestException ex) {
            log.error("error in project", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            log.error("error in creating project");
            return ApiResponseBuilder.getErrorResponse(null, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
