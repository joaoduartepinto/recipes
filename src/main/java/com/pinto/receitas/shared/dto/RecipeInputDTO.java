package com.pinto.receitas.shared.dto;

import lombok.Setter;

import java.util.List;

public class RecipeInputDTO {

    private final String recipeName;
    private final List<String> ingredients;
    private final String steps;
    private final String timeOfCooking;

    public RecipeInputDTO(String recipeName, List<String> ingredients, String steps, String timeOfCooking) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.steps = steps;
        this.timeOfCooking = timeOfCooking;
    }




    public String unpackName() {
        return this.recipeName;
    }

    public List<String> unpackIngredients() {
        return this.ingredients;
    }

    public String unpackSteps() {
        return this.steps;
    }

    public String unpackTimeOfCooking() {
        return this.timeOfCooking;
    }

}
