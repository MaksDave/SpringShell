package ru.maksdave.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.maksdave.springcourse.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static Long PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Max"));
        people.add(new Person(++PEOPLE_COUNT, "Second"));
        people.add(new Person(++PEOPLE_COUNT, "Third"));
        people.add(new Person(++PEOPLE_COUNT, "Fourth"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(Long id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
}
