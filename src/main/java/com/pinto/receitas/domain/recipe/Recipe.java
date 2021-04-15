package com.pinto.receitas.domain.recipe;

import com.pinto.receitas.domain.Entity;
import com.pinto.receitas.shared.valueobjects.Ingredient;
import com.pinto.receitas.shared.valueobjects.RecipeName;
import com.pinto.receitas.shared.valueobjects.Steps;
import com.pinto.receitas.shared.valueobjects.TimeOfCooking;
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
    //@Setter
    private List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(RecipeName recipeName, Steps steps, TimeOfCooking timeOfCooking, List<Ingredient> ingredients) {
        this.recipeName = recipeName;
        this.steps = steps;
        this.timeOfCooking = timeOfCooking;
        this.ingredients = ingredients;
    }

    public Recipe(String recipeName, String steps, String timeOfCooking) {
        this.recipeName = new RecipeName(recipeName);
        this.steps = new Steps(steps);
        this.timeOfCooking = new TimeOfCooking(timeOfCooking);
    }
}
