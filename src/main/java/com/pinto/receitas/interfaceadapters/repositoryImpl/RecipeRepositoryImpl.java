package com.pinto.receitas.interfaceadapters.repositoryImpl;

import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.interfaceadapters.repositoryJpaInter.RecipeJpaRepository;
import com.pinto.receitas.shared.datamodel.IngredientJpa;
import com.pinto.receitas.shared.datamodel.RecipeJpa;
import com.pinto.receitas.shared.datamodel.RecipeNameJpa;
import com.pinto.receitas.shared.datamodel.assemblers.IngridientDomainDataAssembler;
import com.pinto.receitas.shared.datamodel.assemblers.RecipeDomainDataAssembler;
import com.pinto.receitas.shared.valueobjects.Ingredient;
import com.pinto.receitas.shared.valueobjects.RecipeName;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class RecipeRepositoryImpl implements RecipeRepositoryInter {

    @Autowired
    RecipeJpaRepository recipeJpaRepository;

    @Autowired
    RecipeDomainDataAssembler recipeDomainDataAssembler;

    @Override
    public Recipe findById(RecipeName recipeName) {
        RecipeNameJpa recipeNameJpa = new RecipeNameJpa(recipeName.toString());

        Optional<RecipeJpa> optional = recipeJpaRepository.findById(recipeNameJpa);

        Recipe recipe;

        if (optional.isPresent()) {
            RecipeJpa recipeJpa = optional.get();

            recipe = recipeDomainDataAssembler.toDomain(recipeJpa);

            return recipe;
        } else
            throw new IllegalArgumentException("Recipe Does not exists");

    }

    @Override
    public void save(Recipe recipe) {

        RecipeJpa recipeJpa = recipeDomainDataAssembler.toData(recipe);

        recipeJpaRepository.save(recipeJpa);

        //List<Ingredient> ingredients = recipe.getIngredients();

        /*for (Ingredient ingredient : ingredients) {
            IngredientJpa ingredientJpa = ingridientDomainDataAssembler.toData(ingredient, recipeJpa);
            ingredientsJpaRepository.save(ingredientJpa);
        }

         */

    }
}
