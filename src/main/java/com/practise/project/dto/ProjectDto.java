package com.practise.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
	
	private Integer id;
	
//	@NotNull(message = "Project Name can not be null")
//    @NotBlank(message = "Project Name can not be blank")
	private String projectName;
	
//	@NotNull(message = "Project Code can not be null")
//    @NotBlank(message = "Project Code can not be blank")
	private String projectCode;
}
