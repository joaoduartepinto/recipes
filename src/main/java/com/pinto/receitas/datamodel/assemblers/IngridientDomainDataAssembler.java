package com.pinto.receitas.datamodel.assemblers;

import com.pinto.receitas.datamodel.IngredientJpa;
import com.pinto.receitas.datamodel.RecipeJpa;
import com.pinto.receitas.domain.valueobjects.Ingredient;
import org.springframework.stereotype.Component;

@Component
public class IngridientDomainDataAssembler {

    public IngredientJpa toData(Ingredient ingredient, RecipeJpa recipeJpa) {

        IngredientJpa ingredientJpa = new IngredientJpa(ingredient, recipeJpa);

        return ingredientJpa;
    }

    public Ingredient toDomain(IngredientJpa ingredientJpa) {
        Ingredient ingredient = new Ingredient(ingredientJpa.getIngredient());
        return ingredient;
    }
}
