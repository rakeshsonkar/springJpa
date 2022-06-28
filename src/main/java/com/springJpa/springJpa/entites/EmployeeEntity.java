package com.springJpa.springJpa.entites;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.springJpa.springJpa.enums.Gender;
import com.springJpa.springJpa.enums.IdentityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name="Employee",uniqueConstraints= {
@UniqueConstraint(name="uk_identity_type_number",columnNames= {"identityType","identity_number"})
})
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
//Entity(name="EmployeeEntity")->call  the  entityname  call  the  code  
public class EmployeeEntity extends AbstractEntity {

	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
//,columnDefinition="Enum('ENGINEERING','MARKETING','SALE','HR')"
//	@Column(name="department")
//	@Enumerated(EnumType.STRING)
//	private Department department;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name="identityType")
	@Enumerated(EnumType.STRING)
	private IdentityType identityType;
	
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private RoleEntity role;
}
