package br.com.luksosilva.repository;

import br.com.luksosilva.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}