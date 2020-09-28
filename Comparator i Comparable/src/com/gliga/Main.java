package com.gliga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Djordje", 18));
        persons.add(new Person("Milica", 16));
        persons.add(new Person("Marija", 17));

        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person.getName() + " " + person.getYear());
        }
    }
}
