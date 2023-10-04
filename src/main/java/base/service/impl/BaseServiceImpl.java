package base.service.impl;

import base.entity.BaseEntity;
import base.repository.BaseRepository;
import base.service.BaseService;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    protected static final Logger logger = Logger.getLogger(BaseServiceImpl.class.getSimpleName());

    static  {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler(BaseServiceImpl.class.getSimpleName()+".log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fileHandler);
    }
    @Override
    public E save(E e) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" save start in service");
        repository.getEntityManager().getTransaction().begin();
        repository.save(e);
        repository.getEntityManager().getTransaction().commit();
        return e;
    }


    @Override
    public E update(E e) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" update start in service");
        repository.getEntityManager().getTransaction().begin();
        repository.update(e);
        repository.getEntityManager().getTransaction().commit();
        return e;
    }

    @Override
    public void delete(E e) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" delete start in service");
        repository.getEntityManager().getTransaction().begin();
        repository.delete(e);
        repository.getEntityManager().getTransaction().commit();

    }

    @Override
    public E findById(ID id) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" findId start in service");
        E e = repository.findById(id);
        e.setId(id);
        return e;
    }

    @Override
    public List<E> findAll() {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" findAll start in service");
        return repository.findAll();
    }

    @Override
    public boolean isContainById(ID id) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" isContainById start in service");
        return repository.isContainById(id);
    }
}
