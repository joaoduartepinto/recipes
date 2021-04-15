package com.pinto.receitas.shared.valueobjects;

public class Steps implements ValueObject{

    private final String steps;

    public Steps(String steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return this.steps;
    }
}
