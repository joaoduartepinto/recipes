package com.pinto.receitas.application.appservicesInter;

import com.pinto.receitas.dto.RecipeHEADOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetRecipesServiceInter {

    Page<RecipeHEADOutputDTO> getRecipes(Pageable pageable);
}
