package com.pinto.receitas.shared.valueobjects;

public class RecipeName implements RecipeID{

    private String name;

    public RecipeName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
