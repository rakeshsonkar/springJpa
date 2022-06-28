package com.springJpa.springJpa.entites;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
}
