package com.pinto.receitas.application.appservicesInter;

import com.pinto.receitas.dto.RecipeOutputDTO;

public interface GetRecipeServiceInter {
    RecipeOutputDTO getRecipe(String recipeName);
}
