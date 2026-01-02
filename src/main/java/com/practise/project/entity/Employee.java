package com.practise.project.entity;

import java.util.HashSet;
import java.util.Set;
import com.authlibrary.model.AuditableEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "tbl_employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends AuditableEntity {

    @Column(name = "emp_name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    /* ---------------- One-to-One Profile ---------------- */

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    /* ---------------- Department ---------------- */

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    /* ---------------- Projects ---------------- */

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "employee_project",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private Set<Project> projects = new HashSet<>();

    /* ---------------- Helper methods ---------------- */

    public void setProfile(Profile profile) {
        this.profile = profile;
        if (profile != null) {
            profile.setEmployee(this);
        }
    }
}

