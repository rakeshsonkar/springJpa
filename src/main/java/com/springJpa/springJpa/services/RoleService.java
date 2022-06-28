package com.springJpa.springJpa.services;

import java.util.List;
import java.util.Optional;
import com.springJpa.springJpa.DTOs.RoleDto;
import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Designation;

public interface RoleService {

	RoleDto createrole(final RoleDto roledto);
	Optional<RoleDto> updateRoleById(final Long roleId,final RoleDto roledto);
	Optional<RoleDto> getRoleById(final Long roleId);
	List<Designation> getAllDesignationByDepartment(final Department department);
	List<Designation>customMethod1(final Department department);

	
}
