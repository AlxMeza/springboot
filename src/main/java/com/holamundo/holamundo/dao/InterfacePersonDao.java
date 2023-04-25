package com.holamundo.holamundo.dao;
import org.springframework.data.repository.CrudRepository;
import com.holamundo.holamundo.domain.Person;

public interface InterfacePersonDao extends CrudRepository<Person, Long>{

}
