package com.practise.project.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practise.project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

	Optional<Employee> findByMobileNumberAndActive(String mobileNumber, boolean b);

	Optional<Employee> findByIdAndActive(Long id, boolean b);

	Page<Employee> findByActive(boolean b, Pageable pageableInstance);
}
