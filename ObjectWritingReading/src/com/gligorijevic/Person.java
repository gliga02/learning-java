package com.gligorijevic;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int year;
    private static final long serialVersionUID = 1L;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + " - " + year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
