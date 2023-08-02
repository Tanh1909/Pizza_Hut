package com.example.projectbase.domain.entity.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Getter
public class BaseEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
}
