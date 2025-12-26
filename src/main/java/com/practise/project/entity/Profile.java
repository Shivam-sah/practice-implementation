package com.practise.project.entity;

import com.practise.project.model.AuditableEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_profile")
@EqualsAndHashCode(callSuper = true)
public class Profile extends AuditableEntity{
		
	@Column(name = "location")
	private String location;
	
	@Column(name = "career_level")
	private String careerLevel;
	
	@Column(name = "role")
	private String role;
	
	@OneToOne(mappedBy = "profile" , cascade = CascadeType.ALL)
//	@JoinColumn(name = "emp_id")
	private Employee employee;
}
