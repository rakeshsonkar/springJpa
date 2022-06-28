package com.springJpa.springJpa.model.responses;

import java.time.LocalDateTime;

import com.springJpa.springJpa.enums.ProjectStatus;

import lombok.Data;

@Data
public class ProjectResponse {
private Long id;
private String name;
private String description;
private ProjectStatus status;
private LocalDateTime finishedOn;
}
