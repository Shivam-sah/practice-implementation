package com.practise.project.dto;

import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDto {
	
	@NotNull(message = "Id can not be Null")
	private Long Id;
	
	@NotNull(message = "Name can not be Null")
	@NotBlank(message = "Name can not be blank")
	private String name;
	
	@NotNull(message = "Email can not be Null")
	@NotBlank(message = "Email can not be blank")
	private String email;
	
	private ProfileDto profile;
	
	private List<Long> projectIds;
	
	private Long departmentId;
}
