package com.pinto.receitas.application.appservicesImpl;

import com.pinto.receitas.application.appservicesInter.GetRecipeServiceInter;
import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.shared.dto.RecipeOutputDTO;
import com.pinto.receitas.shared.dto.assemblers.RecipeDomainDTOAssembler;
import com.pinto.receitas.shared.valueobjects.RecipeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetRecipeServiceImpl implements GetRecipeServiceInter {

    @Autowired
    RecipeRepositoryInter recipeRepositoryInter;

    @Autowired
    RecipeDomainDTOAssembler recipeDomainDTOAssembler;

    @Override
    public RecipeOutputDTO getRecipe(String getRecipeName) {

        RecipeName recipeName = new RecipeName(getRecipeName);

        Optional<Recipe> optionalRecipe = recipeRepositoryInter.findById(recipeName);

        Recipe recipe;

        if (optionalRecipe.isPresent()) {
            recipe = optionalRecipe.get();
        } else
            throw new IllegalArgumentException("ups");

        return recipeDomainDTOAssembler.toOutputDTO(recipe);
    }
}
