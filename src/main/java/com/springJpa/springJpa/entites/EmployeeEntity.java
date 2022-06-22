package com.springJpa.springJpa.entites;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Gender;
import com.springJpa.springJpa.enums.IdentityType;

@Entity
@Table(name="Employee")
//Entity(name="EmployeeEntity")->call  the  entityname  call  the  code  
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
//,columnDefinition="Enum('ENGINEERING','MARKETING','SALE','HR')"
	@Column(name="department")
	@Enumerated(EnumType.STRING)
	private Department department;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="identityType")
	@Enumerated(EnumType.STRING)
	private IdentityType identityType;
	
	@Column(name="Salary")
	private BigDecimal Salary;
	
	@Column(name="postion")
	private String postion;
}
