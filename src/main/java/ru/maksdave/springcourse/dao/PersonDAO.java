package ru.maksdave.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.maksdave.springcourse.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Max", 24, "maxEmail@name.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Second", 33, "secondEmail@name.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Third", 55, "thirdEmail@name.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Fourth", 19, "fourthEmail@name.ru"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatedPerson.getName());
        personToBeUpdate.setAge(updatedPerson.getAge());
        personToBeUpdate.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p->p.getId()==id);
    }
}
