package com.springJpa.springJpa.model.responses;

import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Designation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class RoleResponse extends IDedResponse {
	private Designation designation;
	private Department department;
}
