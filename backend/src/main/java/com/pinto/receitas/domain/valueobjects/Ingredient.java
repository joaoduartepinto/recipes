package com.pinto.receitas.domain.valueobjects;

public class Ingredient implements ValueObject {

    private final String ingredient;

    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return this.ingredient;
    }
}
