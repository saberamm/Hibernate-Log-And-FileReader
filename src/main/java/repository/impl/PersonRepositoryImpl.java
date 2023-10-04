package repository.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Person;
import jakarta.persistence.EntityManager;
import repository.PersonRepository;

import java.util.logging.Level;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person, Long> implements PersonRepository {

    public PersonRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Person findPersonByUsername(String username) {
        BaseRepositoryImpl.logger.log(Level.INFO,getEntityClass().getSimpleName() + " findPersonByUsername start in repository");
        return getEntityManager().createQuery("from " + getEntityClass().getSimpleName() +" where username= :uname", getEntityClass())
                .setParameter("uname", username).getResultStream().findFirst().orElse(null);
    }
}