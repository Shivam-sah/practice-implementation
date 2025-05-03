package com.practise.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.practise.project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer>{

}
