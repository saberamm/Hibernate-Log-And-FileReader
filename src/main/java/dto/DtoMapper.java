package dto;

import entity.Person;
import entity.dto.SimplePerson;

public interface DtoMapper {
    SimplePerson PersonDtoMapper(Person person);
}
