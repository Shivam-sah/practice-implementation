package com.practise.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practise.project.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

	Optional<Department> findByDeptCodeAndActive(String deptCode, boolean active);

	Optional<Department> findByIdAndActive(Integer id, boolean b);

}
