package com.practise.project.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practise.project.builder.Paging;
import com.practise.project.dto.ProjectDto;
import com.practise.project.entity.Project;
import com.practise.project.exception.BadApiRequestException;
import com.practise.project.exception.ResourceNotFoundException;
import com.practise.project.repository.ProjectRepository;
import com.practise.project.service.ProjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectServiceImpl implements ProjectService{
	
	private final ProjectRepository projectRepository;	
	private final ModelMapper modelMapper;

	@Override
	public ProjectDto createProject(ProjectDto request) {
		try {
				Optional<Project> project = projectRepository.findByProjectCodeAndActive(request.getProjectCode(),true);
				if(project.isPresent()) {
					 throw new BadApiRequestException("Project already exist");
				}			
				Project savedProject = projectRepository.save(modelMapper.map(request, Project.class));			
				return modelMapper.map(savedProject, ProjectDto.class);			
		}catch(Exception ex) {
			throw ex;			
		}
	}

	@Override
	public ProjectDto getProject(Integer id) {
		try {
			Project project = projectRepository.findByIdAndActive(id, true).orElseThrow( () -> new BadApiRequestException("Project with this Id do not exists"));		
			return modelMapper.map(project, ProjectDto.class);
		} catch (Exception ex) {
			throw ex;
		}

	}

	@Override
	public ProjectDto deleteProject(Integer id) {
		try {
			Optional<Project> project = projectRepository.findByIdAndActive(id, true);
			if (!project.isPresent()) {
				throw new BadApiRequestException("Project with this Id do not exists");
			}	
			
			Project deletedProject = project.get();
			deletedProject.setActive(false);
			Project savedProject = projectRepository.save(deletedProject);
			return modelMapper.map(savedProject, ProjectDto.class);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public ProjectDto updateProject(@Valid ProjectDto request) {
		try {
			Project project = projectRepository.findByProjectCodeAndActive(request.getProjectCode(),true).orElseThrow( () -> new BadApiRequestException("Project with this code do not exists"));			
			Project savedProject = projectRepository.save(modelMapper.map(request, Project.class));			
			return modelMapper.map(savedProject, ProjectDto.class);		
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public Page<ProjectDto> getAllProject(Paging req) {
		try {
			Pageable pageableInstance = req.getPageableInstance();
			Page<Project> projectList = projectRepository.findAll(pageableInstance);
			if (projectList.getContent().isEmpty() || projectList.isEmpty()) {
				throw new ResourceNotFoundException("Project list not found");
			}
			
			Page<ProjectDto> dtoPage = projectList.map(project ->
	        	modelMapper.map(project, ProjectDto.class)
			);
			return dtoPage;			
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	
}
