package base.repository.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {
    protected static final Logger logger = Logger.getLogger(BaseRepositoryImpl.class.getSimpleName());

    static {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler(BaseRepositoryImpl.class.getSimpleName() + ".log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fileHandler);
    }

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public abstract Class<E> getEntityClass();

    @Override
    public E save(E e) {
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " save start in repository");
        entityManager.persist(e);
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " save end in repository");
        return e;
    }

    @Override
    public E update(E e) {
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " update start in repository");
        return entityManager.merge(e);
    }

    @Override
    public void delete(E e) {
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " delete start in repository");
        entityManager.remove(e);
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " delete end in repository");
    }

    @Override
    public E findById(ID id) {
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " finding by id  start in repository");
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public List<E> findAll() {
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " finding all start in repository");
        return entityManager.createQuery("from " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public boolean isContainById(ID id) {
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " isContainById method start in repository");
        TypedQuery<Long> query = entityManager.createQuery("select count(e) from " + getEntityClass().getSimpleName() + " e where e.id = :pk", Long.class);
        Long countId = query.setParameter("pk", id).getSingleResult();
        return countId == 1L;
    }

    @Override
    public EntityManager getEntityManager() {
        logger.log(Level.INFO, getEntityClass().getSimpleName() + " getEntityManager called in repository");
        return entityManager;
    }
}
