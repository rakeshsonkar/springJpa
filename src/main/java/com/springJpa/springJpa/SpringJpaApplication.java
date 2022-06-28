package com.springJpa.springJpa;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springJpa.springJpa.DTOs.RoleDto;
import com.springJpa.springJpa.enums.Department;
import com.springJpa.springJpa.enums.Designation;
import com.springJpa.springJpa.services.RoleService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringJpaApplication {

//	@Autowired
//	private RoleService roleService;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}
	//@PostConstruct
	//private void init() {
		//roleService.customMethod1(Department.ENGINEERING);
//		RoleDto roleDto =new RoleDto();
//		roleDto.setDesignation(Designation.ARCHITECT);
//		roleDto.setDepartment(Department.ENGINEERING);
//		try {
//			Optional<RoleDto> roleDtoOptional = roleService.updateRoleById(5L, roleDto);
//			if(roleDtoOptional.isPresent()) {
//				log.info("showing data  " ,roleDtoOptional.get());
//			}
//		}catch(final Exception e) {
//			log.info("geoooo fddd nbb,hkj;nhhjov ",e);
//		}
		
//		roleDto=roleService.createrole(roleDto);
//		log.info("insert value",roleDto);
//		RoleDto roleDto1 =new RoleDto();
//		roleDto1.setDesignation(Designation.ASSOCATATE_MARKTER);
//		roleDto1.setDepartment(Department.ENGINEERING);
//		roleDto1=roleService.createrole(roleDto1);
//		System.out.println(roleDto1);
//		log.info("insert value",roleDto1);
	//}

}
