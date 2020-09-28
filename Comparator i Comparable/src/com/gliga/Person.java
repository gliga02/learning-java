package com.gliga;

import java.util.Comparator;

public class Person implements Comparable<Person> {
    private String name;
    private int year;
    static final Comparator<Person> YEAR_ORDER;

    static {
        YEAR_ORDER = new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                if (person1.getYear() < person2.getYear()) {
                    return -1;
                }

                else if (person1.getYear() > person2.getYear()) {
                    return 1;
                }

                return 0;
            }
        };
    }

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Person person) {
        if (this.year > person.year) {
            return 1;
        }

        else if (person.year > this.year) {
            return -1;
        }

        else return 0;
    }
}
