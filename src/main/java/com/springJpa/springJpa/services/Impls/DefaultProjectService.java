package com.springJpa.springJpa.services.Impls;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springJpa.springJpa.DTOs.ProjectDTOs;
import com.springJpa.springJpa.entites.ProjectEntity;
import com.springJpa.springJpa.enums.ProjectStatus;
import com.springJpa.springJpa.exceptions.ProjectNotFoundException;
import com.springJpa.springJpa.repositories.ProjectRepository;
import com.springJpa.springJpa.services.ProjectService;
import com.springJpa.springJpa.utils.DataMapperUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultProjectService implements ProjectService {
	 
	@Autowired
	private ProjectRepository projectRepository;
	@Override
	public ProjectDTOs create(ProjectDTOs projctDTOs) {
		log.debug("creating method run", projctDTOs );
		ProjectEntity projectEntity=DataMapperUtil.converTo(projctDTOs,ProjectEntity.class);
		log.debug("convervalue : ",projectEntity);
		projectEntity.setStatus(ProjectStatus.Active);
		projectEntity = projectRepository.save(projectEntity);
		return DataMapperUtil.converTo(projectEntity,ProjectDTOs.class);
	}

	@Override
	public Optional<ProjectDTOs> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProjectDTOs update(Long id, ProjectDTOs projectDTOs) throws ProjectNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
