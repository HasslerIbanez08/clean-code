package co.com.personalsoft.springbootdocker.services;

import co.com.personalsoft.springbootdocker.dao.PersonDAO;
import co.com.personalsoft.springbootdocker.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PersonService {
    private PersonDAO personDAO;
    @Autowired
    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    public Person savePerson(Person person){
        return personDAO.save(person);
    }
    public Person updatePerson(Person person){
        return  personDAO.save(person);
    }
    public void delete(Person person){
        personDAO.delete(person);
    }
    public Iterable<Person> personAll(){
        return personDAO.findAll();
    }
    public Optional<Person> personById(int id){
        return personDAO.findById(id);
    }
}
