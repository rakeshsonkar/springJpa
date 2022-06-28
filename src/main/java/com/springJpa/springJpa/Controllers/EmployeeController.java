package com.springJpa.springJpa.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springJpa.springJpa.model.requests.EmplopyeeCreationRequest;
import com.springJpa.springJpa.model.responses.ApiResponse;
import com.springJpa.springJpa.model.responses.EmployeeResponse;
import com.springJpa.springJpa.utils.DataMapperUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("employees")
@Slf4j
public class EmployeeController {

	private EmployeeService employeeService;
	
	public ResponseEntity<ApiResponse<EmployeeResponse>> createEmployee(
@Validated @RequestBody final EmplopyeeCreationRequest emplopyeeCreationRequest){
		
		log.info("get request",emplopyeeCreationRequest);
		EmployeeDTO employeeDTO = DataMapperUtil.converTo(emplopyeeCreationRequest,EmployeeDTO.class);
		
		
		final EmployeeResponse employeeResponse = DataMapperUtil.converTo(employeeDTO,EmployeeResponse.class);
		
		return ResponseEntity.ok(ApiResponse.success(employeeResponse));
		
	}
}
