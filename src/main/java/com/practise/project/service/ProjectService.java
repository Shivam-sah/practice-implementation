package com.practise.project.service;

import org.springframework.data.domain.Page;

import com.practise.project.builder.Paging;
import com.practise.project.dto.EmployeeDto;
import com.practise.project.dto.ProjectDto;
import com.practise.project.dto.UpdateProjectDto;

import jakarta.validation.Valid;

public interface ProjectService {

	ProjectDto createProject(ProjectDto request);

	ProjectDto getProject(Integer id);

	ProjectDto deleteProject(Integer id);

	ProjectDto updateProject(@Valid UpdateProjectDto request);

	Page<ProjectDto> getAllProject(Paging req);

}
