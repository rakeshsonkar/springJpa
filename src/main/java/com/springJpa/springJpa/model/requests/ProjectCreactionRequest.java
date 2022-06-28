package com.springJpa.springJpa.model.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProjectCreactionRequest {

	@NotNull
	@NotEmpty
	@Size(min = 1, max = 255)
	private String name;
	@Size(min =1,max=255)
	private String description;
}
