package com.pinto.receitas.shared.dto;

import com.pinto.receitas.shared.valueobjects.RecipeName;
import org.springframework.hateoas.RepresentationModel;

public class AddRecipeResponseDTO extends RepresentationModel<AddRecipeResponseDTO> {

    private String recipeName;

    public AddRecipeResponseDTO(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeName() {
        return recipeName;
    }
}
