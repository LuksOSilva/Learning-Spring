package br.com.luksosilva.mapper.custom;


import br.com.luksosilva.data.dto.PersonDTO;
import br.com.luksosilva.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personMapperV1")
public class PersonMapper {

    public PersonDTO convertEntityToDTO(Person entity) {
        PersonDTO dto = new PersonDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAddress(entity.getAddress());
        dto.setGender(entity.getGender());

        return dto;
    }

    public Person convertDTOToEntity(PersonDTO dto) {
        Person entity = new Person();

        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setGender(dto.getGender());

        return entity;
    }

    public List<PersonDTO> convertEntityListToDTOList(List<Person> entityList) {

        List<PersonDTO> dtoList = new ArrayList<>();

        for (Person entity : entityList) {
            dtoList.add(convertEntityToDTO(entity));
        }

        return dtoList;
    }

    public List<Person> convertDTOListToEntityList(List<PersonDTO> dtoList) {

        List<Person> personList = new ArrayList<>();

        for (PersonDTO dto : dtoList) {
            personList.add(convertDTOToEntity(dto));
        }

        return personList;
    }



}
