package com.server.server.herkansing_repository;

import com.server.server.herkansing_model.Identifiable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class EntityRepository<E extends Identifiable> implements IEntityRepository<E> {

    @PersistenceContext
    EntityManager entityManager;
    private Class<E> entityClass;

    public EntityRepository(Class<E> entityClass){
        this.entityClass = entityClass;
        System.out.println("Created " + this.getClass().getName() + "<" + this.entityClass.getSimpleName() + ">");
    }

}
