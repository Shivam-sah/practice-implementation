package com.practise.project.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmployee {
	
	private Long id;

	private String name;

	private String email;
	
	private String mobileNumber;
	
	private ProfileDto profile;
}
