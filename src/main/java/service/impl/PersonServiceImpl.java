package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Person;
import entity.dto.SimplePerson;
import repository.PersonRepository;
import service.PersonService;
import dto.DtoMapper;
import util.ApplicationContext;

import java.util.logging.Level;

public class PersonServiceImpl extends BaseServiceImpl<Person, Long, PersonRepository> implements PersonService {

    public DtoMapper dtoMapper;

    public PersonServiceImpl(PersonRepository repository, DtoMapper dtoMapper) {
        super(repository);
        this.dtoMapper = dtoMapper;
    }

    @Override
    public SimplePerson findPersonByUsername(String username) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" findPersonByUsername start in service");
        return dtoMapper.PersonDtoMapper(repository.findPersonByUsername(username));
    }

    @Override
    public Person signUp(String firstname, String lastname) {
        logger.log(Level.INFO,repository.getEntityClass().getSimpleName()+" signUp start in service");
        Person person = new Person(firstname, lastname);
        return ApplicationContext.getPersonService().save(person);
    }
}
