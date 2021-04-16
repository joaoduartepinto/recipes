package com.pinto.receitas.interfaceadapters.repositoryImpl;

import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.interfaceadapters.repositoryJpaInter.IngredientsJpaRepository;
import com.pinto.receitas.interfaceadapters.repositoryJpaInter.RecipeJpaRepository;
import com.pinto.receitas.shared.datamodel.IngredientJpa;
import com.pinto.receitas.shared.datamodel.RecipeJpa;
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
    IngredientsJpaRepository ingredientsJpaRepository;

    @Autowired
    RecipeDomainDataAssembler recipeDomainDataAssembler;

    @Autowired
    IngridientDomainDataAssembler ingridientDomainDataAssembler;

    @Override
    public Optional<Recipe> findById(RecipeName recipeName) {
        Optional<RecipeJpa> optional = recipeJpaRepository.findById(recipeName.toString());

        if (optional.isPresent()) {
            RecipeJpa recipeJpa = optional.get();

            Recipe recipe = recipeDomainDataAssembler.toDomain(recipeJpa);

            List<IngredientJpa> ingredientJpaList = ingredientsJpaRepository.findIngredientJpaByRecipeJpa(recipeJpa);

            List<Ingredient> ingredients = new ArrayList<>();

            for (IngredientJpa ingredientJpa : ingredientJpaList) {
                Ingredient ingredient = ingridientDomainDataAssembler.toDomain(ingredientJpa);

                ingredients.add(ingredient);
            }

            recipe.setIngredients(ingredients);

            return Optional.of(recipe);
        } else
            return Optional.empty();

    }

    @Override
    public void save(Recipe recipe) {

        RecipeJpa recipeJpa = recipeDomainDataAssembler.toData(recipe);

        recipeJpaRepository.save(recipeJpa);

        List<Ingredient> ingredients = recipe.getIngredients();

        for (Ingredient ingredient : ingredients) {
            IngredientJpa ingredientJpa = ingridientDomainDataAssembler.toData(ingredient, recipeJpa);
            ingredientsJpaRepository.save(ingredientJpa);
        }

    }
}
