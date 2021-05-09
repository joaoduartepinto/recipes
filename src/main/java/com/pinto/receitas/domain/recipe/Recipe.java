package com.pinto.receitas.domain.recipe;

import com.pinto.receitas.domain.Entity;
import com.pinto.receitas.domain.valueobjects.Ingredient;
import com.pinto.receitas.domain.valueobjects.RecipeName;
import com.pinto.receitas.domain.valueobjects.Steps;
import com.pinto.receitas.domain.valueobjects.TimeOfCooking;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Entity<RecipeName> {

    @Getter
    private RecipeName recipeName;
    @Getter
    private Steps steps;
    @Getter
    private TimeOfCooking timeOfCooking;
    @Getter
    @Setter
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(RecipeName recipeName, Steps steps, TimeOfCooking timeOfCooking, List<Ingredient> ingredients) {
        this.recipeName = recipeName;
        this.steps = steps;
        this.timeOfCooking = timeOfCooking;
        this.ingredients = ingredients;
    }

    public Recipe(RecipeName recipeName, Steps steps, TimeOfCooking timeOfCooking) {
        this.recipeName = recipeName;
        this.steps = steps;
        this.timeOfCooking = timeOfCooking;
    }
}
