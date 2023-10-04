package dto;

import entity.Person;
import entity.dto.SimplePerson;

public class DtoMapperImpl implements DtoMapper {
    @Override
    public SimplePerson PersonDtoMapper(Person person) {
        if (person == null) {
            return null;
        }
        SimplePerson simplePerson = new SimplePerson();
        simplePerson.setFirstname(person.getFirstName());
        simplePerson.setLastname(person.getLastName());
        simplePerson.setUsername(person.getUsername());
        simplePerson.setBirthDate(person.getBirthDate());

        return simplePerson;
    }
}
