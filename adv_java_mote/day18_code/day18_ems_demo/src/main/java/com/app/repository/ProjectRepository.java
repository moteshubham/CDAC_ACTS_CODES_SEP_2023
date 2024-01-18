package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
