package com.pinto.receitas.interfaceadapters.repositoryJpaInter;

import com.pinto.receitas.shared.datamodel.RecipeJpa;
import com.pinto.receitas.shared.datamodel.RecipeNameJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeJpaRepository extends JpaRepository<RecipeJpa, RecipeNameJpa> {

    boolean existsByRecipeName(RecipeNameJpa recipeNameJpa);
}
