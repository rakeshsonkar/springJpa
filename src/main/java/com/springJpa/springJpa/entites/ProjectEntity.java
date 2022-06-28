package com.springJpa.springJpa.entites;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.springJpa.springJpa.enums.ProjectStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity(name="project")
@Table(name="project",uniqueConstraints= {
@UniqueConstraint(name="uk_project",columnNames= {"name"})
})
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class ProjectEntity extends AbstractEntity {

	@Column(nullable=false)
	private String name;
	
	@Column
	private String description;
	
	@Column(name="status",nullable=false)
	@Enumerated(EnumType.STRING)
	private ProjectStatus status;
	
	@Column
	private LocalDateTime finishedOn;
}
