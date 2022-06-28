package com.springJpa.springJpa.DTOs;

import java.time.LocalDateTime;

import com.springJpa.springJpa.enums.ProjectStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ProjectDTOs extends AbstractDto {
	private String name;
	private String description;
	private ProjectStatus status;
	private LocalDateTime finishedOn;
}
