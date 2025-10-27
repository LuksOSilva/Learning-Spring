package br.com.luksosilva.services;

import br.com.luksosilva.data.dto.PersonDTO;
import br.com.luksosilva.exception.ResourceNotFoundException;
import br.com.luksosilva.mapper.custom.PersonMapper;
import br.com.luksosilva.model.Person;
import br.com.luksosilva.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;
    @Autowired
    PersonMapper personMapper;

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!");

        return personMapper.convertEntityListToDTOList(repository.findAll());
    }


    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found fot this ID"));

        return personMapper.convertEntityToDTO(entity);
    }

    public PersonDTO create(PersonDTO dto) {
        logger.info("Creating one Person!");

        Person entity = personMapper.convertDTOToEntity(dto);

        return personMapper.convertEntityToDTO(repository.save(entity));
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No Records found fot this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personMapper.convertEntityToDTO(repository.save(entity));
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found fot this ID"));

        repository.delete(entity);
    }
}
