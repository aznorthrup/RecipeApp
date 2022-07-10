package com.norbry.recipeapp.repository;

import com.norbry.recipeapp.entity.Recipe;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	@Query(value="SELECT * FROM recipe ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> findAll();
	
	@Query(value="SELECT * FROM recipe WHERE user_email = 'barb@barb.com' ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> barbsRecipes();
	
	@Query(value="SELECT * FROM recipe WHERE recipe_type = 'Breakfast' ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> breakfast();
	@Query(value="SELECT * FROM recipe WHERE recipe_type = 'Lunch' ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> lunch();
	@Query(value="SELECT * FROM recipe WHERE recipe_type = 'Dinner' ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> dinner();
	@Query(value="SELECT * FROM recipe WHERE recipe_type = 'Dessert' ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> dessert();
	@Query(value="SELECT * FROM recipe WHERE recipe_type = 'Beverage' ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> beverages();
	@Query(value="SELECT * FROM recipe WHERE recipe_type = 'Other' ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> other();
	
	@Query(value="SELECT * FROM recipe WHERE (recipe_type = 'Breakfast') AND (user_email = 'barb@barb.com') ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> barbBreakfast();
	@Query(value="SELECT * FROM recipe WHERE (recipe_type = 'Lunch') AND (user_email = 'barb@barb.com') ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> barbLunch();
	@Query(value="SELECT * FROM recipe WHERE (recipe_type = 'Dinner') AND (user_email = 'barb@barb.com') ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> barbDinner();
	@Query(value="SELECT * FROM recipe WHERE (recipe_type = 'Dessert') AND (user_email = 'barb@barb.com') ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> barbDessert();
	@Query(value="SELECT * FROM recipe WHERE (recipe_type = 'Beverage') AND (user_email = 'barb@barb.com') ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> barbBeverage();
	@Query(value="SELECT * FROM recipe WHERE (recipe_type = 'Other') AND (user_email = 'barb@barb.com') ORDER BY name", nativeQuery=true)
	public Iterable<Recipe> barbOther();

}
