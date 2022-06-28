package com.springJpa.springJpa.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Designation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity(name="role")
@Table(name="role",uniqueConstraints= {
		@UniqueConstraint(name="uk_designation_department",columnNames= {"designation","department"})
		})
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class RoleEntity extends AbstractEntity {

@Enumerated(EnumType.STRING)
 private Designation designation;
 
@Enumerated(EnumType.STRING)
 private Department department;
 
 @OneToMany(mappedBy="role")
 private List<EmployeeEntity> employee;
}
