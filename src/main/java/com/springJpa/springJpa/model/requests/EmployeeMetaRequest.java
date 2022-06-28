package com.springJpa.springJpa.model.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeeMetaRequest {
	@NotEmpty
	@Size(min=10,max=20)
	private String phone;
	
	@NotEmpty
	@Size(min=5,max=50)
	private String email;
}
