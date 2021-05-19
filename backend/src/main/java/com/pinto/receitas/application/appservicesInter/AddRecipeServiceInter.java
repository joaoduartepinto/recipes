package com.pinto.receitas.application.appservicesInter;

import com.pinto.receitas.dto.AddRecipeResponseDTO;
import com.pinto.receitas.dto.RecipeInputDTO;

public interface AddRecipeServiceInter {

    AddRecipeResponseDTO createRecipe(RecipeInputDTO recipeInputDTO);
}
