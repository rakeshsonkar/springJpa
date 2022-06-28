package com.springJpa.springJpa.services;

import java.util.Optional;

import com.springJpa.springJpa.DTOs.ProjectDTOs;
import com.springJpa.springJpa.exceptions.ProjectNotFoundException;

public interface ProjectService {

ProjectDTOs create(final ProjectDTOs projctDTOs);
Optional<ProjectDTOs> findById(final Long id);
ProjectDTOs update(final Long id,final ProjectDTOs projectDTOs) throws ProjectNotFoundException;
}
