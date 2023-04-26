package com.holamundo.holamundo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// import com.holamundo.holamundo.dao.InterfacePersonDao;
import com.holamundo.holamundo.service.PersonServiceImp;

import jakarta.validation.Valid;

import com.holamundo.holamundo.domain.Person;

@Controller
public class WebController {
    @Autowired
    // private InterfacePersonDao PersonDao;
    /*Añadiremos la capa de servicio*/
    private PersonServiceImp personService;

    @GetMapping("/persons")
    public String getPersons (Model model) {
        // var personList = PersonDao.findAll();
        var personList = personService.list();
        model.addAttribute("personList", personList);
        return "persons";
    }

    @GetMapping("/addperson")
    public String addPerson(Person person){
        return "configperson";
    }

    @PostMapping("/save")
    public String savePerson(@Valid Person person, Errors errors){
        if(errors.hasErrors()) return "configperson";
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String editPerson(Person person, Model model){
        person = personService.find(person);
        model.addAttribute("person", person);
        return "configperson";
    }

    @GetMapping("/delete")
    public String deletePerson (Person person){
        personService.delete(person);
        return "redirect:/persons";
    }
}
