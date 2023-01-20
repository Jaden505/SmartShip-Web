package com.server.server.herkansing_repository;


import com.server.server.herkansing_model.Identifiable;

import java.util.List;

public interface IEntityRepository<E extends Identifiable> {
    List<E> findAll();

    E findById(long id);

    E save(E entity);
}
