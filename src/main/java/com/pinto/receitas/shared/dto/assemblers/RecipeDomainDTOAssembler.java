package com.pinto.receitas.shared.dto.assemblers;

import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.shared.dto.RecipeInputDTO;
import com.pinto.receitas.shared.dto.RecipeOutputDTO;
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


    public Recipe toRecipe(RecipeInputDTO recipeInputDTO) {

        RecipeName recipeName = new RecipeName(recipeInputDTO.unpackName());

        Steps steps = new Steps(recipeInputDTO.unpackSteps());

        TimeOfCooking timeOfCooking = new TimeOfCooking(recipeInputDTO.unpackTimeOfCooking());

        List<Ingredient> ingredients = new ArrayList<>();

        for (String ingredientsInDTO : recipeInputDTO.unpackIngredients()) {
            ingredients.add(new Ingredient(ingredientsInDTO));
        }


        return new Recipe(recipeName, steps, timeOfCooking, ingredients);
    }

    public RecipeOutputDTO toOutputDTO(Recipe recipe){

        RecipeOutputDTO recipeDTO = new RecipeOutputDTO(recipe.getRecipeName().toString(), recipe.getSteps().toString(), recipe.getTimeOfCooking().toString());

        List<Ingredient> ingredientList = recipe.getIngredients();
        List<String> ingredientDTOList = new ArrayList<>();


        for (Ingredient ingredient : ingredientList) {
            ingredientDTOList.add(ingredient.toString());
        }

        recipeDTO.setIngredients(ingredientDTOList);


        return recipeDTO;
    }
}
