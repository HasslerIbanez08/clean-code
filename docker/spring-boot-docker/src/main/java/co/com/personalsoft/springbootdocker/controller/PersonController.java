package co.com.personalsoft.springbootdocker.controller;

import co.com.personalsoft.springbootdocker.execptions.ModelNotFountException;
import co.com.personalsoft.springbootdocker.models.Person;
import co.com.personalsoft.springbootdocker.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {
    public static final String PERSON_NO_FOUND = "Person no found";

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping("/")
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person);
    }
    @GetMapping("/")
    public Iterable<Person> getAll(){
        return personService.personAll();
    }
    @GetMapping("/{id}")
    public Person getById(@PathVariable int id){
        Optional<Person> person = personService.personById(id);
        if(person.isPresent()){
            return  person.get();
        }
        throw new ModelNotFountException(PERSON_NO_FOUND);
    }
}
