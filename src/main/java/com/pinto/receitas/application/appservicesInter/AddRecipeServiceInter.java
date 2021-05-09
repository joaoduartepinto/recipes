package com.pinto.receitas.application.appservicesInter;

import com.pinto.receitas.shared.dto.AddRecipeResponseDTO;
import com.pinto.receitas.shared.dto.RecipeInputDTO;

public interface AddRecipeServiceInter {

    AddRecipeResponseDTO createRecipe(RecipeInputDTO recipeInputDTO);
}
