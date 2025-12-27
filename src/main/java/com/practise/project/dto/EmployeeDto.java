package com.practise.project.dto;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practise.project.entity.Project;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {	
	private Integer id;
	
	@NotNull(message = "Name can not be Null")
	@NotBlank(message = "Name can not be blank")
	private String name;
	
	@NotNull(message = "Email can not be Null")
	@NotBlank(message = "Email can not be blank")
	private String email;
	
	
	@NotNull(message = "Mobile Number can not be Null")
	@NotBlank(message = "Mobile Number can not be blank")
	private String mobileNumber;
	

	private ProfileDto profile; 
	
	private Set<ProjectDto> projects;
		
	private List<Integer> projectIds;
}
