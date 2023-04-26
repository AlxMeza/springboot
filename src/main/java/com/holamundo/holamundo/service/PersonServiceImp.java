package com.holamundo.holamundo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.holamundo.holamundo.domain.Person;
import com.holamundo.holamundo.dao.InterfacePersonDao;

@Service
public class PersonServiceImp implements InterfacePersonService {
    @Autowired
    private InterfacePersonDao personDao;

    @Override
    @Transactional(readOnly = true)
    public List<Person> list() {
        return (List<Person>) personDao.findAll();
    }

    @Override
    @Transactional
    public void save(Person person) {
        personDao.save(person);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        personDao.delete(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person find(Person person) {
        return personDao.findById(person.getId()).orElse(null);
    }
    
}
