package db.services;

import db.dao.PersonDAO;
import db.model.Person;

import java.util.List;

public class PersonService {
    private PersonDAO personDAO;

    public PersonService() {
        personDAO = new PersonDAO();
    }

    public List<Person> getAllPeople() {
        return personDAO.getAll();
    }

    public Person getPersonByID(int id) {
        return personDAO.getByID(id);
    }

    public void savePerson(Person person) {
        personDAO.save(person);
    }

    public void updatePerson(Person person) {
        personDAO.update(person);
    }

    public void deletePersonByID(int id) {
        personDAO.deleteByID(id);
    }
}
