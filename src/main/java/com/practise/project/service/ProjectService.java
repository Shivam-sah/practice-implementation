package com.practise.project.service;

import org.springframework.data.domain.Page;
import com.authlibrary.builder.Paging;
import com.practise.project.dto.ProjectDto;
import com.practise.project.dto.ProjectDtoDup;
import com.practise.project.dto.UpdateProjectDto;
import jakarta.validation.Valid;

public interface ProjectService {

	ProjectDto createProject(ProjectDto request);

	ProjectDtoDup getProject(Long id);

	ProjectDto deleteProject(Long id);

	ProjectDto updateProject(@Valid UpdateProjectDto request);

	Page<ProjectDtoDup> getAllProject(Paging req);
}
