package com.practise.project.entity;

import com.practise.project.model.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbl_project")
@EqualsAndHashCode(callSuper = true)
public class Project extends AuditableEntity{
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "project_code")
	private String projectCode;

}
