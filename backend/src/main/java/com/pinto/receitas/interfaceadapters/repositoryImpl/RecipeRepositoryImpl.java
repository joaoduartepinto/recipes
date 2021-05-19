package com.pinto.receitas.interfaceadapters.repositoryImpl;

import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.interfaceadapters.repositoryJpaInter.RecipeJpaRepository;
import com.pinto.receitas.datamodel.RecipeJpa;
import com.pinto.receitas.datamodel.RecipeNameJpa;
import com.pinto.receitas.datamodel.assemblers.RecipeDomainDataAssembler;
import com.pinto.receitas.domain.valueobjects.RecipeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.stream.Collectors;

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
    public Recipe save(Recipe recipe) {

        RecipeNameJpa recipeNameJpa = new RecipeNameJpa(recipe.getRecipeName().toString());

        checkIfAlreadyExists(recipeNameJpa);

        RecipeJpa recipeJpa = recipeDomainDataAssembler.toData(recipe);

        RecipeJpa savedRecipeJpa = recipeJpaRepository.save(recipeJpa);

        Recipe savedRecipe = recipeDomainDataAssembler.toDomain(savedRecipeJpa);

        return savedRecipe;

    }

    @Override
    public Page<Recipe> findAll(Pageable pageable) {
        Page<RecipeJpa> recipeJpaPage = recipeJpaRepository.findAll(pageable);

        //Page<Recipe> recipePage;

        Page<Recipe> recipePage = recipeJpaPage.map(recipeJpa -> recipeDomainDataAssembler.toDomain(recipeJpa));

        return recipePage;
    }

    private void checkIfAlreadyExists(RecipeNameJpa recipeNameJpa) {
        if (recipeJpaRepository.existsByRecipeName(recipeNameJpa))
            throw new IllegalArgumentException("Recipe already exists");
    }
}
