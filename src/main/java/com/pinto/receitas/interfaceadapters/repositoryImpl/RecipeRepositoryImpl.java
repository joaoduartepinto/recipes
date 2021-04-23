package com.pinto.receitas.interfaceadapters.repositoryImpl;

import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.interfaceadapters.repositoryJpaInter.RecipeJpaRepository;
import com.pinto.receitas.shared.datamodel.RecipeJpa;
import com.pinto.receitas.shared.datamodel.RecipeNameJpa;
import com.pinto.receitas.shared.datamodel.assemblers.RecipeDomainDataAssembler;
import com.pinto.receitas.shared.valueobjects.RecipeName;
import org.springframework.beans.factory.annotation.Autowired;

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

        RecipeNameJpa recipeNameJpa = new RecipeNameJpa(recipe.getRecipeName().toString());

        checkIfAlreadyExists(recipeNameJpa);

        RecipeJpa recipeJpa = recipeDomainDataAssembler.toData(recipe);

        recipeJpaRepository.save(recipeJpa);

    }

    private void checkIfAlreadyExists(RecipeNameJpa recipeNameJpa) {
        if (recipeJpaRepository.existsByRecipeName(recipeNameJpa))
            throw new IllegalArgumentException("Recipe already exists");
    }
}
