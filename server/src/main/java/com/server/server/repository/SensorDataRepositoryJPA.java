package com.server.server.repository;

import com.server.server.model.SensorData;
import com.server.server.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class SensorDataRepositoryJPA {

    @PersistenceContext
    private EntityManager entityManager;
//
//    public List<SensorData> getCategories() {
//        TypedQuery<SensorData> namedQuery = entityManager.createQuery("SELECT distinct SensorData.sensorName FROM SensorData");
//        return namedQuery.getResultList();
//    }
}
