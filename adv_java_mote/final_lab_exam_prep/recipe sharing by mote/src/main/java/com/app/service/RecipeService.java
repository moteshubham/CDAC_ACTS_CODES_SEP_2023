package com.app.service;

import com.app.entities.Recipe;

public interface RecipeService {
	Recipe getRecipe(Integer recipeId);
	Recipe createRecipe(Recipe recipe);
	Recipe updateRecipe(Integer recipeId, Recipe recipe);
	String deleteRecipe(Integer recipeId);
}
