package service;

import base.service.BaseService;
import entity.Person;
import entity.dto.SimplePerson;

public interface PersonService extends BaseService<Person, Long> {
    SimplePerson findPersonByUsername(String username);
    Person signUp (String firstname,String lastname);
}
