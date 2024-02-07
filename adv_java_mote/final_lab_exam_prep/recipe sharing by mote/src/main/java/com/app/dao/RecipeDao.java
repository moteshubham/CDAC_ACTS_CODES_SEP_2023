package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Recipe;

public interface RecipeDao extends JpaRepository<Recipe, Integer> {
	
	
}
