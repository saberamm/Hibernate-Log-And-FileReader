package dto;

import base.service.impl.BaseServiceImpl;
import entity.Person;
import entity.dto.SimplePerson;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DtoMapperImpl implements DtoMapper {
    private static final Logger logger = Logger.getLogger(DtoMapperImpl.class.getSimpleName());

    static  {
        FileHandler fileHandler;
        try {
            fileHandler = new FileHandler(DtoMapperImpl.class.getSimpleName()+".log");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.addHandler(fileHandler);
    }
    @Override
    public SimplePerson PersonDtoMapper(Person person) {
        if (person == null) {
            return null;
        }
        logger.log(Level.INFO,"DtoMapper start for person");
        SimplePerson simplePerson = new SimplePerson();
        simplePerson.setFirstname(person.getFirstName());
        simplePerson.setLastname(person.getLastName());
        simplePerson.setUsername(person.getUsername());
        simplePerson.setBirthDate(person.getBirthDate());

        return simplePerson;
    }
}
