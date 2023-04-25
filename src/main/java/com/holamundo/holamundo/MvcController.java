package com.holamundo.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;

import lombok.extern.slf4j.Slf4j;
import com.holamundo.holamundo.domain.*;

@Controller
@Slf4j

public class MvcController {

    @Value("${index.saludo}")
    private String saludo;
    
    @GetMapping("/")
    public String getInicio(Model model) {
        var saludar = "Hola mundo con thymeleaf";
        log.info("Ejecutando mvc Controller");
        model.addAttribute("mensaje", saludar);
        model.addAttribute("message", saludo);
        return "index";
    }

    @GetMapping("/person")
    public String getPerson(Model model) {
        var person = new Persona();
        person.setNombre("Juan");
        person.setApellido("Perez");
        person.setEmail("juanPerez@mail.com");
        person.setTelefono("2225664321");

        var person2 = new Persona();
        person2.setNombre("Karla");
        person2.setApellido("Gomez");
        person2.setEmail("karlaGomez@mail.com");
        person2.setTelefono("55443322");

        /*Crear lista opcion 1*/
        // var personList = new ArrayList();
        // personList.add(person);
        // personList.add(person2);

        /*Crear lista opcion 2*/
        var personList = Arrays.asList(person, person2);

        // model.addAttribute("persona", person);
        model.addAttribute("personList", personList);
        return "person";
    }
}
