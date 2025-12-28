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
public class UpdateDepartmentDto {
	
	@NotNull(message = "Id can not be null")
	private Integer id;
	
	@NotNull(message = "Department Name can not be null")
    @NotBlank(message = "Department Name can not be blank")
	private String deptName;
	
	@NotNull(message = "Department Name can not be null")
    @NotBlank(message = "Department Name can not be blank")
	@Pattern(
		    regexp = "^[A-Z]+$",
		    message = "Department code must be in capital"
		)
	private String deptCode;
	
	private String description;

}
