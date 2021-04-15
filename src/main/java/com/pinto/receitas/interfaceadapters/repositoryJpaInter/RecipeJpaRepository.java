package com.pinto.receitas.interfaceadapters.repositoryJpaInter;

import com.pinto.receitas.shared.datamodel.RecipeJpa;
import com.pinto.receitas.shared.valueobjects.RecipeName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeJpaRepository extends JpaRepository<RecipeJpa, String> {
}
