package com.pinto.receitas.datamodel.assemblers;

import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.datamodel.IngredientJpa;
import com.pinto.receitas.datamodel.RecipeJpa;
import com.pinto.receitas.datamodel.RecipeNameJpa;
import com.pinto.receitas.domain.valueobjects.Ingredient;
import com.pinto.receitas.domain.valueobjects.RecipeName;
import com.pinto.receitas.domain.valueobjects.Steps;
import com.pinto.receitas.domain.valueobjects.TimeOfCooking;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeDomainDataAssembler {

    public RecipeJpa toData(Recipe recipe) {

        RecipeNameJpa recipeNameJpa = new RecipeNameJpa(recipe.getRecipeName().toString());

        RecipeJpa recipeJpa = new RecipeJpa(recipeNameJpa, recipe.getSteps(), recipe.getTimeOfCooking());

        List<Ingredient> ingredientList = recipe.getIngredients();
        List<IngredientJpa> ingredientJpaList = new ArrayList<>();

        for (Ingredient ingredient : ingredientList) {
            ingredientJpaList.add(new IngredientJpa(ingredient, recipeJpa));

        }

        recipeJpa.setIngredientJpas(ingredientJpaList);

        return recipeJpa;
    }

    public Recipe toDomain(RecipeJpa recipeJpa) {
        RecipeName recipeName = new RecipeName(recipeJpa.getRecipeName().toString());

        Steps steps = new Steps(recipeJpa.getSteps());

        TimeOfCooking timeOfCooking = new TimeOfCooking(recipeJpa.getTimeOfCooking());

        Recipe recipe = new Recipe(recipeName, steps, timeOfCooking);

        List<IngredientJpa> ingredientJpaList = recipeJpa.getIngredientJpas();

        List<Ingredient> ingredients = new ArrayList<>();

        for (IngredientJpa ingredientJpa : ingredientJpaList) {
            ingredients.add(new Ingredient(ingredientJpa.getIngredient()));
        }

        recipe.setIngredients(ingredients);

        return recipe;
    }
}
