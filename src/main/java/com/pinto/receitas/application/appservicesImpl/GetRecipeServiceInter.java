package com.pinto.receitas.application.appservicesImpl;

import com.pinto.receitas.shared.dto.RecipeOutputDTO;

public interface GetRecipeServiceInter {
    RecipeOutputDTO getRecipe(String recipeName);
}
