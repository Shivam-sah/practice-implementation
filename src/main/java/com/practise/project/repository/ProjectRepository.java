package com.practise.project.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practise.project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

	Optional<Project> findByProjectCodeAndActive(String projectName, Boolean b);

	Optional<Project> findByIdAndActive(Long id, boolean b);

	Page<Project> findByActive(Boolean b, Pageable pageableInstance);

}
