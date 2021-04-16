package com.pinto.receitas.application.appservicesImpl;

import com.pinto.receitas.application.appservicesInter.AddRecipeServiceInter;
import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.shared.dto.RecipeInputDTO;
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
    public void createRecipe(RecipeInputDTO recipeInputDTO) {

        Recipe newRecipe = recipeDomainDTOAssembler.toRecipe(recipeInputDTO);

        recipeRepositoryInter.save(newRecipe);
    }
}
