package com.practise.project.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDtoDup {
	
	private Long id;
	
	private String deptName;
	
	private String deptCode;
	
	private String description;
	
	private Set<DeptEmployee> employees ;
}
