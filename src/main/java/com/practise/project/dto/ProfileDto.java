package com.practise.project.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
	@NotNull(message = "location can not be Null")
	@NotBlank(message = "location can not be blank")
	private String location;
	
	@NotNull(message = "careerLevel can not be Null")
	@NotBlank(message = "careerLevel can not be blank")
	private Integer careerLevel;
	
	@NotNull(message = "Role can not be Null")
	@NotBlank(message = "Role can not be blank")
	private String role;
}
