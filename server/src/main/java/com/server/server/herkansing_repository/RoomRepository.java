package com.server.server.herkansing_repository;

import com.server.server.herkansing_model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoomRepository extends EntityRepository<Room> {

    public RoomRepository() {
        super(Room.class);
    }

    @Override
    public List<Room> findAll() {
        TypedQuery<Room> query =
                this.entityManager.createQuery(
                        "SELECT t FROM Room t", Room.class
                );
        return query.getResultList();
    }

    @Override
    public Room findById(long id) {
        TypedQuery<Room> query =
                this    .entityManager.createQuery(
                        "SELECT h FROM Room h WHERE h.id = ?1", Room.class
                );
        return query.setParameter(1, id).getSingleResult();
    }

    @Override
    public Room save(Room entity) {
        entityManager.merge(entity);
        return entity;
    }
}
