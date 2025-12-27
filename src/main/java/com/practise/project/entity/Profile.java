package com.practise.project.entity;

import com.practise.project.model.AuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_profile")
public class Profile extends AuditableEntity{
		
	@Column(name = "location")
	private String location;
	
	@Column(name = "career_level")
	private Integer careerLevel;
	
	@Column(name = "role")
	private String role;
	
	
	@OneToOne(mappedBy = "profile" ,cascade = CascadeType.ALL)
//	@OneToOne
//	@JoinColumn(name = "emp_id")
	private Employee employee;
}
