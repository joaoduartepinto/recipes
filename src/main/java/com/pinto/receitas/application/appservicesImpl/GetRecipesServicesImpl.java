package com.pinto.receitas.application.appservicesImpl;

import com.pinto.receitas.application.appservicesInter.GetRecipesServiceInter;
import com.pinto.receitas.application.repositoryInter.RecipeRepositoryInter;
import com.pinto.receitas.domain.recipe.Recipe;
import com.pinto.receitas.dto.RecipeHEADOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GetRecipesServicesImpl implements GetRecipesServiceInter {

    @Autowired
    RecipeRepositoryInter recipeRepositoryInter;

    @Override
    public Page<RecipeHEADOutputDTO> getRecipes(Pageable pageable) {

        Page<Recipe> recipePage = recipeRepositoryInter.findAll(pageable);

        Page<RecipeHEADOutputDTO> recipeHEADOutputDTOS = recipePage.map(recipe -> new RecipeHEADOutputDTO(recipe.getRecipeName().toString(), recipe.getTimeOfCooking().toString()));

        return recipeHEADOutputDTOS;
    }
}
