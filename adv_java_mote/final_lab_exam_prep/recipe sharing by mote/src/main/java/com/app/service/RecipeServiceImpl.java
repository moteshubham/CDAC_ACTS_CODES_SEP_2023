package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RecipeDao;
import com.app.entities.Recipe;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;

	@Override
	public Recipe getRecipe(Integer recipeId) {
		System.out.println(recipeDao.findById(recipeId).orElseThrow());
		return recipeDao.findById(recipeId).orElseThrow();
	}

	@Override
	public Recipe createRecipe(Recipe recipe) {

		return recipeDao.save(recipe);
	}

	@Override
	public Recipe updateRecipe(Integer recipeId, Recipe recipe) {
		if(recipeDao.existsById(recipeId))
			return recipeDao.save(recipe);
		else
			return recipe;
	}

	@Override
	public String deleteRecipe(Integer recipeId) {

		recipeDao.deleteById(recipeId);
		return "Deleted successfully";
	}

}
