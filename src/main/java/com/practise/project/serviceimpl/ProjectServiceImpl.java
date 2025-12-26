package com.practise.project.serviceimpl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.practise.project.dto.ProjectDto;
import com.practise.project.entity.Project;
import com.practise.project.exception.BadApiRequestException;
import com.practise.project.repository.ProjectRepository;
import com.practise.project.service.ProjectService;
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
				Optional<Project> project = projectRepository.findByProjectCodeAndActive(request.getProjectName(),true);
				if(project.isPresent()) {
					 throw new BadApiRequestException("Project already exist");
				}			
				Project savedProject = projectRepository.save(modelMapper.map(request, Project.class));			
				return modelMapper.map(savedProject, ProjectDto.class);			
		}catch(Exception ex) {
			throw ex;			
		}
	}
	
	
}
