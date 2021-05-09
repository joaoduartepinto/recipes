package com.pinto.receitas.application.repositoryInter;

import com.pinto.receitas.domain.recipe.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface Repository <T, K>{

    T findById(K k);

    T save(T t);

    Page<T> findAll(Pageable pageable);

}
