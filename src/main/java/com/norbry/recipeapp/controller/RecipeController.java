package com.norbry.recipeapp.controller;

import com.norbry.recipeapp.entity.Recipe;
import com.norbry.recipeapp.repository.RecipeRepository;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepo;

    private final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("/recipes")
    public String allRecipes(Model model){
        Iterable<Recipe> recipes = recipeRepo.findAll();
        logger.info("Displayed all recipes");
        model.addAttribute("recipes", recipes);
        return "recipes";
    }

    @GetMapping("/recipes/{id}")
    public String recipeByID(@PathVariable Long id, Model model) {
        logger.info("Displayed recipe with id: " + id);
        Recipe recipe = recipeRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Could not find recipe with id" + id));
        model.addAttribute("recipe", recipe);
        String[] ingredients = recipe.getIngredients().split(", ");
        model.addAttribute("ingredients", ingredients);
        String[] ingredient_amounts = recipe.getIngredient_amounts().split(", ");
        model.addAttribute("ingredient_amounts", ingredient_amounts);
        String[] measurement_labels = recipe.getMeasurement_labels().split(", ");
        model.addAttribute("measurement_labels", measurement_labels);
        return "recipe";
    }

    @GetMapping("/recipes/add")
    public String addRecipe(Model model){
        logger.info("Displayed add recipe page");
        model.addAttribute("recipe", new Recipe());
        return "add-recipe";
    }
    
    @PostMapping("/recipes/add")
    public String addRecipePost(@Valid Recipe recipe, BindingResult bind) {
    	if (bind.hasErrors()) {
    		logger.info("Failed to create new recipe");
    		return "add-recipe";
    	}else {
    		recipeRepo.save(recipe);
    		logger.info("Saved new recipe with id: " + recipe.getRecipeId());
    		return "redirect:/recipes";
    	}
    }
    
    @GetMapping("/recipes/update/{id}")
    public String updateRecipePage(@PathVariable("id") Long id, Model model) throws IllegalArgumentException {
    	Recipe recipe = recipeRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Could not find lock with id: " + id));
    	model.addAttribute("recipe", recipe);
        String[] ingredients = recipe.getIngredients().split(", ");
        model.addAttribute("ingredients", ingredients);
        String[] ingredient_amounts = recipe.getIngredient_amounts().split(", ");
        model.addAttribute("ingredient_amounts", ingredient_amounts);
        String[] measurement_labels = recipe.getMeasurement_labels().split(", ");
        model.addAttribute("measurement_labels", measurement_labels);
    	logger.info("Displayed update page for recipe with id: " + id);
    	return "update-recipe";
    }
    
    @PostMapping("/recipes/update/{id}")
    public String updateRecipe(@PathVariable("id") Long id, @Valid Recipe recipe, BindingResult bind, Model model) {
    	if (bind.hasErrors()) {
    		recipe.setRecipeId(id);
    		logger.info("Failed to update recipe with id: " + id);
    		return "update-recipe";
    	}else {
    		recipe.setRecipeId(id);
    		recipeRepo.save(recipe);
    		logger.info("Updated recipe with id: " + id);
    		return "redirect:/recipes/{id}";
    	}
    }
    
    @GetMapping("/recipes/delete/{id}")
    public String deleteRecipe(@PathVariable("id") Long id, Model model) throws IllegalArgumentException{
    	Recipe recipe = recipeRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid recipe id: " + id));
    	logger.info("Deleted recipe with id: " + id);
    	recipeRepo.delete(recipe);
    	return "redirect:/recipes";
    }
    
    @GetMapping("/recipes/barb")
    public String barbsRecipes(Model model) {
    Iterable<Recipe> recipes = recipeRepo.barbsRecipes();
    logger.info("Displayed all of barb's recipes");
    model.addAttribute("recipes", recipes);
    return "barb-recipes";
    }
    
    @GetMapping("/recipes/breakfast")
    public String breakfast(Model model) {
    Iterable<Recipe> recipes = recipeRepo.breakfast();
    logger.info("Displayed all breakfast recipes");
    model.addAttribute("recipes", recipes);
    return "recipes";
    }
    
    @GetMapping("/recipes/lunch")
    public String lunch(Model model) {
    Iterable<Recipe> recipes = recipeRepo.lunch();
    logger.info("Displayed all lunch recipes");
    model.addAttribute("recipes", recipes);
    return "recipes";
    }
    
    @GetMapping("/recipes/dinner")
    public String dinner(Model model) {
    Iterable<Recipe> recipes = recipeRepo.dinner();
    logger.info("Displayed all dinner recipes");
    model.addAttribute("recipes", recipes);
    return "recipes";
    }
    
    @GetMapping("/recipes/dessert")
    public String dessert(Model model) {
    Iterable<Recipe> recipes = recipeRepo.dessert();
    logger.info("Displayed all dessert recipes");
    model.addAttribute("recipes", recipes);
    return "recipes";
    }
    
    @GetMapping("/recipes/beverage")
    public String beverages(Model model) {
    Iterable<Recipe> recipes = recipeRepo.beverages();
    logger.info("Displayed all dessert recipes");
    model.addAttribute("recipes", recipes);
    return "recipes";
    }
    
    @GetMapping("/recipes/other")
    public String other(Model model) {
    Iterable<Recipe> recipes = recipeRepo.other();
    logger.info("Displayed all other recipes");
    model.addAttribute("recipes", recipes);
    return "recipes";
    }
    
    @GetMapping("/recipes/barb/breakfast")
    public String barbBreakfast(Model model) {
    Iterable<Recipe> recipes = recipeRepo.barbBreakfast();
    logger.info("Displayed all of barb's breakfast recipes");
    model.addAttribute("recipes", recipes);
    return "barb-recipes";
    }
    
    @GetMapping("/recipes/barb/lunch")
    public String barbLunch(Model model) {
    Iterable<Recipe> recipes = recipeRepo.barbLunch();
    logger.info("Displayed all of barb's lunch recipes");
    model.addAttribute("recipes", recipes);
    return "barb-recipes";
    }
    
    @GetMapping("/recipes/barb/dinner")
    public String barbDinner(Model model) {
    Iterable<Recipe> recipes = recipeRepo.barbDinner();
    logger.info("Displayed all of barb's dinner recipes");
    model.addAttribute("recipes", recipes);
    return "barb-recipes";
    }
    
    @GetMapping("/recipes/barb/dessert")
    public String barbDessert(Model model) {
    Iterable<Recipe> recipes = recipeRepo.barbDessert();
    logger.info("Displayed all of barb's dessert recipes");
    model.addAttribute("recipes", recipes);
    return "barb-recipes";
    }
    
    @GetMapping("/recipes/barb/beverage")
    public String barbBeverages(Model model) {
    Iterable<Recipe> recipes = recipeRepo.barbBeverage();
    logger.info("Displayed all barb's beverage recipes");
    model.addAttribute("recipes", recipes);
    return "barb-recipes";
    }
    
    @GetMapping("/recipes/barb/other")
    public String barbOther(Model model) {
    Iterable<Recipe> recipes = recipeRepo.barbOther();
    logger.info("Displayed all of barb's other recipes");
    model.addAttribute("recipes", recipes);
    return "barb-recipes";
    }
    
}
