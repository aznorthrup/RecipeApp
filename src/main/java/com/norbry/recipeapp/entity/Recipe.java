package com.norbry.recipeapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long recipeId;
    @NotNull
    @Size(min=4, message="Recipe name name must be greater than 3 characters!")
    private String name;
    @NotNull
    private String recipeType;
    @NotNull
    @Size(min=3, message="Ingredient name must be greater than 2 characters!")
    private String ingredients;
    @NotNull
    @Size(min=1, message="Amount must be greater than 0!")
    private String ingredient_amounts;
    @NotNull
    private String measurement_labels;
    @NotNull
    @Size(min=10, message="Instructions must be more than 9 characters!")
    private String instructions;
    @NotNull
    private String image;
    @NotNull
    private String user_email;

    public Recipe(){}

    public Recipe(String name, String recipeType, @NotNull String ingredients, @NotNull String ingredient_amounts, @NotNull String measurement_labels) {
        this.name = name;
        this.recipeType = recipeType;
        this.ingredients = ingredients;
        this.ingredient_amounts = ingredient_amounts;
        this.measurement_labels = measurement_labels;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredient_amounts() {
        return ingredient_amounts;
    }

    public void setIngredient_amounts(String ingredient_amounts) {
        this.ingredient_amounts = ingredient_amounts;
    }

    public String getMeasurement_labels() {
        return measurement_labels;
    }

    public void setMeasurement_labels(String measurement_labels) {
        this.measurement_labels = measurement_labels;
    }

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
