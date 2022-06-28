package com.springJpa.springJpa.model.requests;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.springJpa.springJpa.enums.Gender;
import com.springJpa.springJpa.enums.IdentityType;
import lombok.Data;

@Data
public class EmplopyeeCreationRequest {
	@NotNull
	@NotEmpty
	@Size(min=1,max=100)
	private String firstName;
	
	@NotEmpty
	@Size(min=1,max=100) 
	private  String lastName;
	
	@NotNull
	private Gender gender;
	
	@NotNull
	private IdentityType identityType;
	
	@NotNull
	@NotEmpty
	@Size(min=1,max=50,message="Id numbe must be within 1to 50 characters")
	private String identityNumber;
	
	@NotNull
	@Min(0)
	private Long roleId;
	
	@Valid
	private EmployeeMetaRequest employeeMetaRequest;
	
}
