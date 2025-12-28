package com.practise.project.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.practise.project.entity.Department;
import com.practise.project.entity.Project;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

	Optional<Department> findByDeptCodeAndActive(String deptCode, boolean active);

	Optional<Department> findByIdAndActive(Long id, boolean b);

	Page<Department> findByActive(boolean b, Pageable pageableInstance);

}
