package ru.maksdave.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.maksdave.springcourse.dao.PersonDAO;
import ru.maksdave.springcourse.model.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController  {

    private final PersonDAO personDAO;


    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @GetMapping()
    public String index(Model model){
        // Get all people from DAO and transfer to the presentation level.
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id,Model model){
        // Receive the person from DAO and transfer to presentation level.
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        // Receive the person from DAO and transfer to presentation level.
        return "people/new";
    }
    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "people/new";
        // Receive the person from DAO and transfer to presentation level.
        personDAO.save(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") int id) {
    model.addAttribute("person", personDAO.show(id));
        // Receive the person from DAO and transfer to presentation level.
        return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,BindingResult bindingResult, @PathVariable("id") int id){
        if(bindingResult.hasErrors())
            return "people/edit";
        personDAO.update(id,person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }
}
