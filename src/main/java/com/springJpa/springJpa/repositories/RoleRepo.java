package com.springJpa.springJpa.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springJpa.springJpa.entites.RoleEntity;
import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Designation;

@Repository
public interface RoleRepo extends IDedRepository<RoleEntity> {

	@Query(value="Select a From role a where a.department=?1 AND a.designation=?2")
	Optional<RoleEntity> customMethod(final Department department, final Designation designation);
	
	@Query(value="Select a From role a where a.department=:department And a.designation=:designation")
	Optional<RoleEntity> customMethod1(@Param("department") final Department department,@Param("designation") final Designation designation);
	
	@Query(value="SELECT * from role a where a.department='ENGINEERING'",nativeQuery=true)
	Optional<RoleEntity> customMethod1();
}
