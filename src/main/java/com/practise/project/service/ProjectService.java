package com.practise.project.service;

import com.practise.project.dto.ProjectDto;

import jakarta.validation.Valid;

public interface ProjectService {

	ProjectDto createProject(ProjectDto request);

}
