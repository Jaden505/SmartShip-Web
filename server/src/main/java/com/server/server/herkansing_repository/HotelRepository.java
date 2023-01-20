package com.server.server.herkansing_repository;

import com.server.server.herkansing_model.Hotel;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HotelRepository extends EntityRepository<Hotel> {

    public HotelRepository() {
        super(Hotel.class);
    }

    @Override
    public List<Hotel> findAll() {
        TypedQuery<Hotel> query =
                this.entityManager.createQuery(
                        "SELECT h FROM Hotel h", Hotel.class
                );
        return query.getResultList();
    }

    @Override
    public Hotel findById(long id) {
        TypedQuery<Hotel> query =
                this    .entityManager.createQuery(
                        "SELECT h FROM Hotel h WHERE h.id = ?1", Hotel.class
                );
        return query.setParameter(1, id).getSingleResult();
    }

    @Override
    public Hotel save(Hotel entity) {
        entityManager.merge(entity);
        return entity;
    }
}
