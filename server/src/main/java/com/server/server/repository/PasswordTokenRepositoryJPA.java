package com.server.server.repository;

import com.server.server.model.PasswordResetToken;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Transactional
@Repository
public class PasswordTokenRepositoryJPA implements PasswordTokenRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PasswordResetToken findByToken(String token) {
        TypedQuery<PasswordResetToken> namedQuery = entityManager.createQuery("SELECT p FROM PasswordResetToken p WHERE p.token = ?1" , PasswordResetToken.class);
        namedQuery.setParameter(1, token);
        return namedQuery.getSingleResult();
    }

    @Override
    public PasswordResetToken getUserByToken(String token) {
        TypedQuery<PasswordResetToken> namedQuery = entityManager.createQuery("SELECT p.user FROM PasswordResetToken p WHERE p.token = ?1" , PasswordResetToken.class);
        namedQuery.setParameter(1, token);
        return namedQuery.getSingleResult();
    }

    @Override
    public List<PasswordResetToken> findAll() {
        return null;
    }

    @Override
    public List<PasswordResetToken> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PasswordResetToken> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PasswordResetToken> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(PasswordResetToken entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends PasswordResetToken> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PasswordResetToken> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PasswordResetToken> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PasswordResetToken> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PasswordResetToken> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PasswordResetToken> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PasswordResetToken> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PasswordResetToken getOne(Long aLong) {
        return null;
    }

    @Override
    public PasswordResetToken getById(Long aLong) {
        return null;
    }

    @Override
    public PasswordResetToken getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends PasswordResetToken> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PasswordResetToken> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PasswordResetToken> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PasswordResetToken> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PasswordResetToken> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PasswordResetToken> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PasswordResetToken, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
