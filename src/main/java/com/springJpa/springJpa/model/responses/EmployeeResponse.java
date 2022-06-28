package com.springJpa.springJpa.model.responses;
import com.springJpa.springJpa.enums.Gender;
import com.springJpa.springJpa.enums.IdentityType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class EmployeeResponse extends IDedResponse {
	
	private String firstName;
	private  String lastName;
	private Gender gender;
	private IdentityType identityType;
	private String identityNumber;
	private RoleResponse role;
	private EmplopyeeMetaResponse employeeMetaResponse;
	
}
