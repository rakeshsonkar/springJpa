package com.springJpa.springJpa.DTOs;


import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Designation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class RoleDto extends AbstractDto {
	private Designation designation;
	 private Department department;
}
