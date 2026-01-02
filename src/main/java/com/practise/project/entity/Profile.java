package com.practise.project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.practise.project.model.AuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile extends AuditableEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5994483598824842648L;

	@Column(name = "location")
    private String location;

    @Column(name = "career_level")
    private Integer careerLevel;

    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "profile" ,fetch = FetchType.LAZY)
 // @JoinColumn(name = "employee_id")
    private Employee employee;
}

