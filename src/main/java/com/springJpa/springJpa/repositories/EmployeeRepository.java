package com.springJpa.springJpa.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springJpa.springJpa.entites.EmployeeEntity;

public interface EmployeeRepository extends IDedRepository<EmployeeEntity>,JpaSpecificationExecutor<EmployeeEntity>{

}
