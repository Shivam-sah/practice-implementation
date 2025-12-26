package com.practise.project.dto;

import com.practise.project.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {	
	private String name;
	
	private String email;
	
	private String mobileNumber;
	
	private Profile profile;
}
