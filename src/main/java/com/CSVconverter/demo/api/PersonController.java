package com.CSVconverter.demo.api;

import com.CSVconverter.demo.model.Person;
import com.CSVconverter.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("api/v1/person")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@RequestBody Person[] person){
        for(Person perso : person) {
            personService.addPerson(perso);
        }
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
}
