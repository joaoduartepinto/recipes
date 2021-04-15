package com.pinto.receitas.shared.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class RecipeOutputDTO {

    @Getter
    private final String recipeName;
    //private List<String> ingredients = new ArrayList<>();
    @Getter
    private final String steps;
    @Getter
    private final String timeOfCooking;

    public RecipeOutputDTO(String recipeName, String timeOfCooking, String steps) {
        this.recipeName = recipeName;
        this.timeOfCooking = timeOfCooking;
        this.steps = steps;
    }

    /*public void setIngredients(List<String> ingredientDTOList) {
        this.ingredients = ingredientDTOList;
    }

     */
}