package com.holamundo.holamundo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import com.holamundo.holamundo.dao.InterfacePersonDao;
import com.holamundo.holamundo.service.PersonServiceImp;

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
}
