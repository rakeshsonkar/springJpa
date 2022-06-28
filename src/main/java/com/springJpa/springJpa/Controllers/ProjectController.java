package com.springJpa.springJpa.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springJpa.springJpa.DTOs.ProjectDTOs;
import com.springJpa.springJpa.constants.ErrorCode;
import com.springJpa.springJpa.model.requests.ProjectCreactionRequest;
import com.springJpa.springJpa.model.responses.ApiResponse;
import com.springJpa.springJpa.model.responses.Error;
import com.springJpa.springJpa.model.responses.ProjectResponse;
import com.springJpa.springJpa.services.ProjectService;
import com.springJpa.springJpa.utils.DataMapperUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("project")
@Slf4j
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@PostMapping
	public ResponseEntity<ApiResponse<ProjectResponse>> createProject(
			@Validated @RequestBody final ProjectCreactionRequest projectCreactionRequest){
		log.info("received Project Creation ",projectCreactionRequest);
		try {
			ProjectDTOs projectDTOs= DataMapperUtil.converTo(projectCreactionRequest,ProjectDTOs.class);
			projectDTOs=projectService.create(projectDTOs);
			final ProjectResponse projectResponse=DataMapperUtil.converTo(projectDTOs, ProjectResponse.class);
			return ResponseEntity.ok(ApiResponse.success(projectResponse));
		} catch ( final DataIntegrityViolationException e) {
			final String message=String.format("project name %s already exist",projectCreactionRequest.getName());
			Error error =Error.create(ErrorCode.DUPLICATE_PROJECT,message);
			return ResponseEntity.badRequest().body(ApiResponse.error(error));
		}
		
		
	}
	
	
}
