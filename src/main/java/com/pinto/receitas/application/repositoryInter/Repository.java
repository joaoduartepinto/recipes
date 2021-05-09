package com.pinto.receitas.application.repositoryInter;

import com.pinto.receitas.domain.recipe.Recipe;

import java.util.Optional;

public interface Repository <T, K>{

    T findById(K k);

    T save(T t);
}
