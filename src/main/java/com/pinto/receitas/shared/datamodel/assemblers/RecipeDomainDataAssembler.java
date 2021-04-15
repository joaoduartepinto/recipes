package com.pinto.receitas.shared.datamodel.assemblers;

import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.shared.datamodel.IngredientJpa;
import com.pinto.receitas.shared.datamodel.RecipeJpa;
import com.pinto.receitas.shared.valueobjects.Ingredient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecipeDomainDataAssembler {

    public RecipeJpa toData(Recipe recipe) {

        RecipeJpa recipeJpa = new RecipeJpa(recipe.getRecipeName(), recipe.getSteps(), recipe.getTimeOfCooking());

        /*
        List<Ingredient> ingredientList = recipe.getIngredients();
        List<IngredientJpa> ingredientJpaList = new ArrayList<>();

        for (Ingredient ingredient: ingredientList) {
            ingredientJpaList.add(new IngredientJpa(ingredient, recipeJpa));

        }



        recipeJpa.setIngredients(ingredientJpaList);

         */

        return recipeJpa;
    }

    //TODO: Incompleto, como fazer para colocar os ingredientes
    public Recipe toDomain(RecipeJpa recipeJpa) {
        return new Recipe(recipeJpa.getRecipeName(), recipeJpa.getSteps(), recipeJpa.getTimeOfCooking());
    }
}
