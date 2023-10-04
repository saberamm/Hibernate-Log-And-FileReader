package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Person;
import entity.dto.SimplePerson;
import repository.PersonRepository;
import service.PersonService;
import dto.DtoMapper;
import util.ApplicationContext;

public class PersonServiceImpl extends BaseServiceImpl<Person, Long, PersonRepository> implements PersonService {

    public DtoMapper dtoMapper;

    public PersonServiceImpl(PersonRepository repository, DtoMapper dtoMapper) {
        super(repository);
        this.dtoMapper = dtoMapper;
    }

    @Override
    public SimplePerson findPersonByUsername(String username) {
        return dtoMapper.PersonDtoMapper(repository.findPersonByUsername(username));
    }

    @Override
    public Person signUp(String firstname, String lastname) {
        Person person = new Person(firstname, lastname);
        return ApplicationContext.getPersonService().save(person);
    }
}
