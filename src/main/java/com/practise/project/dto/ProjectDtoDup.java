package com.practise.project.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDtoDup {	
	private Long id;
	
	private String projectName;
	
	private String projectCode;
	
	private Set<EmployeeDto> employees;
}
