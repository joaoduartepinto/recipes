package com.pinto.receitas.application.appservicesInter;

import com.pinto.receitas.shared.dto.RecipeInputDTO;

public interface AddRecipeServiceInter {

    void createRecipe(RecipeInputDTO recipeInputDTO);
}
