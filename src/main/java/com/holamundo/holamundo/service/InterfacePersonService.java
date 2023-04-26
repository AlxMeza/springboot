package com.holamundo.holamundo.service;

import java.util.List;
import com.holamundo.holamundo.domain.Person;

public interface InterfacePersonService {
    
    public List<Person> list();

    public void save(Person person);

    public void delete (Person person);

    public Person find(Person person);
}
