package com.pinto.receitas.application.appservicesImpl;

import com.pinto.receitas.application.appservicesInter.GetRecipeServiceInter;
import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.dto.RecipeOutputDTO;
import com.pinto.receitas.dto.assemblers.RecipeDomainDTOAssembler;
import com.pinto.receitas.domain.valueobjects.RecipeName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRecipeServiceImpl implements GetRecipeServiceInter {

    @Autowired
    RecipeRepositoryInter recipeRepositoryInter;

    @Autowired
    RecipeDomainDTOAssembler recipeDomainDTOAssembler;

    @Override
    public RecipeOutputDTO getRecipe(String getRecipeName) {

        RecipeName recipeName = new RecipeName(getRecipeName);

        Recipe recipe = recipeRepositoryInter.findById(recipeName);

        return recipeDomainDTOAssembler.toOutputDTO(recipe);
    }
}
