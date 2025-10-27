package br.com.luksosilva.controllers;

import br.com.luksosilva.data.dto.PersonDTO;
import br.com.luksosilva.model.Person;
import br.com.luksosilva.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(
            value = "/find-all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonDTO> findAll() {
        return service.findAll();
    }

    @GetMapping(
            value = "/find-by-id/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO findById(
            @PathVariable("id") Long id
    ) {
        PersonDTO person = service.findById(id);

        person.setBirthday(new Date());

        if (person.getGender().equals("Male")) {
            person.setPhoneNumber("(12) 3456-7890");
            person.setLastName(null);
            person.setSensitiveData("Foo Bar");
        }

        return person;
    }

    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO create(@RequestBody PersonDTO person) {
        return service.create(person);
    }

    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonDTO update(@RequestBody PersonDTO person) {
        return service.update(person);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}