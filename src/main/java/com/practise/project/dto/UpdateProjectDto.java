package com.practise.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProjectDto {
	
	@NotNull(message = "Id can not be null")
	private Long id;
	
	@NotNull(message = "Project Name can not be null")
    @NotBlank(message = "Project Name can not be blank")
	private String projectName;
	
	@Pattern(
		    regexp = "^[A-Z]+$",
		    message = "Project code must be in Capital"
		)
	@NotNull(message = "Project Code can not be null")
    @NotBlank(message = "Project Code can not be blank")
	private String projectCode;

}
