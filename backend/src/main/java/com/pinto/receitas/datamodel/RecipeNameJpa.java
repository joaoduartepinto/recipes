package com.pinto.receitas.datamodel;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@Embeddable
public class RecipeNameJpa implements Serializable {

    private String recipeName;

    public RecipeNameJpa(String recipeName) {
        this.recipeName = recipeName;
    }

    @Override
    public String toString() {
        return this.recipeName;
    }
}
