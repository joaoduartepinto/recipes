package com.pinto.receitas.interfaceadapters.controllers.controllersInter;

import com.pinto.receitas.shared.dto.AddRecipeResponseDTO;
import com.pinto.receitas.shared.dto.RecipeInputDTO;
import com.pinto.receitas.shared.dto.RecipeOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface RecipeController {

    ResponseEntity<AddRecipeResponseDTO> addRecipe(RecipeInputDTO recipeInputDTO);

    ResponseEntity<RecipeOutputDTO> getRecipe(String recipeName);
}