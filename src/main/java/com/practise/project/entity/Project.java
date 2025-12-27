package com.practise.project.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practise.project.model.AuditableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_project")
public class Project extends AuditableEntity{
	
	@Column(name = "project_name" ,nullable  = false)
	private String projectName;
	
	@Column(name = "project_code" , nullable = false, unique = true)
	private String projectCode;
	
	
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employee;
}
