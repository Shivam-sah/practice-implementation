package com.practise.project.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
	
	private Integer id;
	
	@NotNull(message = "Project Name can not be null")
    @NotBlank(message = "Project Name can not be blank")
	private String projectName;
	
	@Pattern(
		    regexp = "^[A-Z]+$",
		    message = "Project code must be uppercase"
		)
	@NotNull(message = "Project Code can not be null")
    @NotBlank(message = "Project Code can not be blank")
	private String projectCode;
	
	@JsonBackReference
	private Set<EmployeeDto> employee;
}
