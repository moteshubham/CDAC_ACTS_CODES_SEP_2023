package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Recipe;
import com.app.service.RecipeService;

@RestController
public class RecipeController {
	@Autowired
	private RecipeService recipeService;

	@GetMapping("/recipes/{recipeId}")
	public ResponseEntity<Object> getRecipe(@PathVariable Integer recipeId) {
		try {
			System.out.println();
			System.out.println("ididididiididididi: " + recipeId);
			Recipe recipe = recipeService.getRecipe(recipeId);
			System.out.println(recipe);
			return ResponseEntity.status(HttpStatus.OK).body(recipe);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PostMapping("/recipes")
	public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
		try {
			System.out.println(recipe.getTitle());
			return ResponseEntity.status(HttpStatus.OK).body(recipeService.createRecipe(recipe));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@PutMapping("/recipes/{recipeId}")
	public ResponseEntity<Object> updateRecipe(@RequestBody Recipe recipe, @PathVariable Integer recipeId) {
		try {
			recipe.setRecipeId(recipeId);
			return ResponseEntity.status(HttpStatus.OK).body(recipeService.updateRecipe(recipeId, recipe));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/recipes/{recipeId}")
	public ResponseEntity<Object> deleteRecipe(@PathVariable Integer recipeId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(recipeService.deleteRecipe(recipeId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
