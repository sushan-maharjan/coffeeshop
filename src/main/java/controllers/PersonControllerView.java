/*
package controllers;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

*/
/**
 * Created by trauma_sushan on 6/18/2017.
 *//*

@Controller
public class PersonControllerView {
    @Autowired
    PersonService personService;

    @GetMapping("/addPerson")
    public String addPerson(){
        return "addPerson";
    }

   @PostMapping("/createPerson")
   @PutMapping("updatePerson")
    public String createPerson(Person person){
       personService.savePerson(person);
       return "redirect:/personList";
   }

   @DeleteMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable long id){
        personService.removePerson(personService.findById(id));
        return "redirect:/personList";
   }

    @GetMapping("/getPerson/{id}")
    public String getPerson(@PathVariable long id, Model model){
        model.addAttribute("person", personService.findById(id));
        return "personDetail";
    }
}

*/
