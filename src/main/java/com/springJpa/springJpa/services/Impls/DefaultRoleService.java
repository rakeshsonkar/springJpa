package com.springJpa.springJpa.services.Impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.management.relation.Role;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springJpa.springJpa.DTOs.RoleDto;
import com.springJpa.springJpa.entites.RoleEntity;
import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Designation;
import com.springJpa.springJpa.repositories.RoleRepo;
import com.springJpa.springJpa.services.RoleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultRoleService implements RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	private final ObjectMapper objectmapper = new  ObjectMapper();
	
	@PostConstruct
	private void init() {
		objectmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	@Override
	public RoleDto createrole(RoleDto roledto) {
		log.info("Creating role: {}",roledto);
		RoleEntity roleEntity =objectmapper.convertValue(roledto, RoleEntity.class);
		roleEntity=roleRepo.save(roleEntity);
		log.info("save Entity",roleEntity);
		
		return objectmapper.convertValue(roleEntity, RoleDto.class);
	}

	@Override
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public Optional<RoleDto> updateRoleById(final Long roleId,final RoleDto roledto) {
		 final Optional<RoleEntity> roleEntityOptional = roleRepo.findById(roleId);
		 if(roleEntityOptional.isPresent()) {
			 final RoleEntity roleEntity =roleEntityOptional.get();
			 if(roledto.getDepartment() !=null) {
				 roleEntity.setDepartment(roledto.getDepartment());
			 }
			 if(roledto.getDesignation() != null) {
				 roleEntity.setDesignation(roledto.getDesignation());
			 }
			 return Optional.of(objectmapper.convertValue(roleEntity, RoleDto.class));
		 }
		 
		 return Optional.empty();
	}

	@Override
	public Optional<RoleDto> getRoleById(Long roleId) {
		final Optional<RoleEntity> roleEntityOptional = roleRepo.findById(roleId);
		if(roleEntityOptional.isPresent()) {
			return Optional.of(objectmapper.convertValue(roleEntityOptional.get(),RoleDto.class));
		}
		return Optional.empty();
	}

	@Override
	public List<Designation> getAllDesignationByDepartment(Department department) {
		log.info("getAllDesignationByDepartment",department);
		final RoleEntity roleEntity =new RoleEntity();
		roleEntity.setDepartment(department);
		Example<RoleEntity> exampleEntity = Example.of(roleEntity);
		List<RoleEntity> searchResult  =roleRepo.findAll(exampleEntity);
		final List<Designation> designations =new ArrayList();
		searchResult.forEach((re)->{
			final Designation designation = re.getDesignation();
			designations.add(designation);
			});
		return designations;
	}

	public List<Designation> customMethod1(final Department department) {
		final Optional<RoleEntity> roleEntity =roleRepo.customMethod(department.ENGINEERING,Designation.ARCHITECT);
		final List<Designation> designations =new ArrayList();
		roleEntity.ifPresent(data->{
			System.out.println(data.getDesignation());
			designations.add(data.getDesignation());
		});
		return designations;
	}
	

}
