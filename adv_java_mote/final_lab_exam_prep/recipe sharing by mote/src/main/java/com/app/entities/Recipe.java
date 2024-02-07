package com.app.entities;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "recipe")
@ToString(callSuper = true)
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipeId;

	private String title;	
	private String description;
	private String ingredients;
	private String instructions;
	@Enumerated(EnumType.STRING)
	private DifficultyLevel defLevel;
	@Enumerated(EnumType.STRING)
	private CuisineType cuisineType;
	private int authorId;
	private LocalDate creationDate;
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public DifficultyLevel getDefLevel() {
		return defLevel;
	}
	public void setDefLevel(DifficultyLevel defLevel) {
		this.defLevel = defLevel;
	}
	public CuisineType getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(CuisineType cuisineType) {
		this.cuisineType = cuisineType;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
