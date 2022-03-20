package com.springboot.uploadCSVFiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.uploadCSVFiles.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
	
}