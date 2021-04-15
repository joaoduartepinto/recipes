package com.pinto.receitas.application.repositoryInter;

import java.util.Optional;

public interface Repository <T, K>{

    Optional<T> findById(K k);

    void save(T t);
}
