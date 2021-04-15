package com.pinto.receitas.shared.dto.assemblers;

import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.shared.dto.RecipeDTO;
import com.pinto.receitas.shared.valueobjects.Ingredient;
import com.pinto.receitas.shared.valueobjects.RecipeName;
import com.pinto.receitas.shared.valueobjects.Steps;
import com.pinto.receitas.shared.valueobjects.TimeOfCooking;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class RecipeDomainDTOAssembler {


    public Recipe toRecipe(RecipeDTO recipeDTO) {

        RecipeName recipeName = new RecipeName(recipeDTO.unpackName());

        Steps steps = new Steps(recipeDTO.unpackSteps());

        TimeOfCooking timeOfCooking = new TimeOfCooking(recipeDTO.unpackTimeOfCooking());

        List<Ingredient> ingredients = new ArrayList<>();

        for (String ingredientsInDTO : recipeDTO.unpackIngredients()) {
            ingredients.add(new Ingredient(ingredientsInDTO));
        }


        return new Recipe(recipeName, steps, timeOfCooking, ingredients);
    }
}
