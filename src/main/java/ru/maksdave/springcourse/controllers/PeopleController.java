package ru.maksdave.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maksdave.springcourse.dao.PersonDAO;

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
    public String show(@PathVariable("id")Long id,Model model){
        // Receive the person from DAO and transfer to presentation level.
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }

}
