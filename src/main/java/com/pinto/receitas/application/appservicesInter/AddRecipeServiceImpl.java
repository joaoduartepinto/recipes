package com.pinto.receitas.application.appservicesInter;

import com.pinto.receitas.application.appservicesImpl.AddRecipeServiceInter;
import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.shared.dto.RecipeDTO;
import com.pinto.receitas.shared.dto.assemblers.RecipeDomainDTOAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddRecipeServiceImpl implements AddRecipeServiceInter {

    @Autowired
    RecipeRepositoryInter recipeRepositoryInter;

    @Autowired
    RecipeDomainDTOAssembler recipeDomainDTOAssembler;

    @Override
    public void createRecipe(RecipeDTO recipeDTO) {

        Recipe newRecipe = recipeDomainDTOAssembler.toRecipe(recipeDTO);

        recipeRepositoryInter.save(newRecipe);
    }
}
