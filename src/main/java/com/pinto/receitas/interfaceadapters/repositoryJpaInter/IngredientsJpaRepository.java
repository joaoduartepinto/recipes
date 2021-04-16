package com.pinto.receitas.interfaceadapters.repositoryJpaInter;


import com.pinto.receitas.shared.datamodel.IngredientJpa;
import com.pinto.receitas.shared.datamodel.RecipeJpa;
import com.pinto.receitas.shared.valueobjects.RecipeName;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientsJpaRepository extends CrudRepository<IngredientJpa, Long> {

    //List<IngredientJpa> findByRecipeName(RecipeName recipeName);
    List<IngredientJpa> findIngredientJpaByRecipeJpa(RecipeJpa recipeJpa);

}


