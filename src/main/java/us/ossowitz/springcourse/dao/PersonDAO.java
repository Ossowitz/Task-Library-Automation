package us.ossowitz.springcourse.dao;

import org.springframework.stereotype.Component;
import us.ossowitz.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PRIMARY_KEY;

    {
        people = new ArrayList<>();

        people.add(new Person(++PRIMARY_KEY, "Ivan", 20, 101));
        people.add(new Person(++PRIMARY_KEY, "Petr", 25, 98));
        people.add(new Person(++PRIMARY_KEY, "Sveta", 18, 126));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> id == person.getId()).findAny().orElse(null);
    }
}
