package com.pinto.receitas.interfaceadapters.controllers.controllersInter;

import com.pinto.receitas.dto.AddRecipeResponseDTO;
import com.pinto.receitas.dto.RecipeInputDTO;
import com.pinto.receitas.dto.RecipeOutputDTO;
import org.springframework.http.ResponseEntity;

public interface RecipeController {

    ResponseEntity<AddRecipeResponseDTO> addRecipe(RecipeInputDTO recipeInputDTO);

    ResponseEntity<RecipeOutputDTO> getRecipe(String recipeName);
}