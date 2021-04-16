package com.pinto.receitas.shared.datamodel.assemblers;

import com.pinto.receitas.shared.datamodel.IngredientJpa;
import com.pinto.receitas.shared.valueobjects.Ingredient;

public class IngridientDomainDataAssembler {

    public IngredientJpa toData(Ingredient ingredient) {

        IngredientJpa ingredientJpa = new IngredientJpa();

        return ingredientJpa;
    }
}
