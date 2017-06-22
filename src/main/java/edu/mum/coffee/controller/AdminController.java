package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by trauma_sushan on 6/22/2017.
 */
@Controller
public class AdminController {

    @Autowired
    PersonService personService;

    @RequestMapping("/personList")
    public String listPerson(){
        return "person";
    }

    @RequestMapping("/addPerson")
    public String addPerson(){
        return "addPerson";
    }

    @PostMapping("/createPerson")
    public String createPerson(Person person){
        personService.savePerson(person);
        return "redirect:/person";
    }

    @GetMapping("listOrder")
    public String listOrder(){
        return "orderList";
    }
}
